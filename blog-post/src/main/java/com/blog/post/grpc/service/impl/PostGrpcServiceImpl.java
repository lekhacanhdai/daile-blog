package com.blog.post.grpc.service.impl;

import com.blog.common.enums.PostStatus;
import com.blog.post.domain.entity.CdcUserEntity;
import com.blog.post.domain.entity.PostEntity;
import com.blog.post.domain.entity.PostTagEntity;
import com.blog.post.domain.repository.CdcUserRepository;
import com.blog.post.domain.repository.PostRepository;
import com.blog.post.domain.repository.PostTagRepository;
import com.blog.post.domain.repository.TagRepository;
import com.blog.post.domain.repository.dsl.PostDslRepository;
import com.blog.post.grpc.mapper.PostGrpcMapper;
import com.blog.post.grpc.service.PostGrpcService;
import com.blog.proto.exception.GrpcNotFoundException;
import com.blog.proto.utils.PageableUtils;
import com.daile.blog.common.IdRequest;
import com.daile.blog.common.IdResponse;
import com.daile.blog.post.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author daile
 * @since 10/06/2024
 */

@Service
@RequiredArgsConstructor
public class PostGrpcServiceImpl implements PostGrpcService {
    private final PostDslRepository postDslRepository;
    private final CdcUserRepository userRepository;
    private final PostRepository postRepository;
    private final PostTagRepository postTagRepository;
    private final PostGrpcMapper postGrpcMapper;
    private final TagRepository tagRepository;

    @Override
    public MListPostResponse listPost(MListPostRequest request) {
        var pagePosts = postDslRepository.listPost(request);
        var userIds = pagePosts.getItems().stream().map(PostEntity::getUserId).collect(Collectors.toSet());

        var userMap = userRepository.findAllById(userIds).stream().collect(Collectors.toMap(CdcUserEntity::getUserId, e -> e));

        return MListPostResponse.newBuilder()
                .setSuccess(true)
                .setData(MListPostResponse.Data.newBuilder()
                        .addAllPosts(postGrpcMapper.toGrpc(pagePosts.getItems(), userMap))
                        .setPageable(PageableUtils.normalize(request.getPageable(), pagePosts.getTotalElement()))
                        .build())
                .build();
    }

    @Override
    public MGetPostByIdResponse getPostById(IdRequest request) {
        var post = postRepository.findById(request.getId().transform(UUID::fromString)).orElseThrow(
                () -> new GrpcNotFoundException("Not found post")
        );
        var user = userRepository.findById(post.getUserId()).orElse(new CdcUserEntity());
        var postTag = postTagRepository.findAllByPostId(post.getPostId());

        return MGetPostByIdResponse.newBuilder()
                .setSuccess(true)
                .setData(MGetPostByIdResponse.Data.newBuilder()
                        .setPost(postGrpcMapper.toGrpc(post, user, postTag))
                        .build())
                .build();
    }

    @Override
    @Transactional
    public MCreatePostResponse createPost(MCreatePostRequest request) {
        // TODO: validate
        var postEntity = toPostEntity(request);
        var savedPost = postRepository.save(postEntity);
        var postTags = toPostTag(request, savedPost);
        if (!postTags.isEmpty()) {
            postTagRepository.saveAll(postTags);
        }

        return MCreatePostResponse.newBuilder()
                .setSuccess(true)
                .setData(IdResponse.newBuilder()
                        .setId(savedPost.getPostId().toString())
                        .build())
                .build();
    }

    private PostEntity toPostEntity(MCreatePostRequest request) {
        PostEntity newPost = new PostEntity();
        newPost.setTitle(request.getTitle());
        newPost.setContent(request.getContent());
        newPost.setStatus(PostStatus.PUBLISH.getId());
        newPost.setUserId(UUID.fromString("7fe41cb8-a415-480c-b90c-1334365d2981"));
        return newPost;
    }

    private List<PostTagEntity> toPostTag(MCreatePostRequest request, PostEntity post) {
        var tags = tagRepository.findAllById(request.getTagIdsList().stream().map(UUID::fromString).toList());
        return tags.stream().map(t -> {
            var postTag = new PostTagEntity();
            postTag.setTag(t);
            postTag.setPost(post);
            return postTag;
        }).toList();

    }
}

package com.blog.gateway.grpc.client.post.impl;

import com.blog.gateway.grpc.client.post.PostGrpcClientService;
import com.blog.gateway.grpc.utils.PageUtils;
import com.blog.gateway.payload.request.post.CreatePostRequest;
import com.blog.gateway.payload.request.post.ListPostRequest;
import com.daile.blog.common.IdRequest;
import com.daile.blog.post.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author daile
 * @since 10/06/2024
 */

@Service
@RequiredArgsConstructor
public class PostGrpcClientServiceImpl implements PostGrpcClientService {
    private final PostGrpcServiceGrpc.PostGrpcServiceBlockingStub postGrpcServiceBlockingStub;
    @Override
    public MListPostResponse listPost(ListPostRequest request) {
        return postGrpcServiceBlockingStub
                .listPost(MListPostRequest.newBuilder()
                        .setPageable(PageUtils.toGrpcPageable(request))
                        .setSearchTerm(StringUtils.defaultString(request.getSearchTerm()))
                        .setUserId(StringUtils.defaultString(request.getUserId()))
                        .addAllTagIds(request.getTagIds() != null ? request.getTagIds() : new ArrayList<>())
                .build());
    }

    @Override
    public MCreatePostResponse createPost(CreatePostRequest request) {
        return postGrpcServiceBlockingStub
//                .withCallCredentials(BlogPrincipalProvider.asGrpcCredentials(SecurityUtils.getPrincipal()))
                .createPost(MCreatePostRequest.newBuilder()
                        .setContent(request.getContent())
                        .setStatus(request.getStatus())
                        .setTitle(request.getTitle())
                        .addAllTagIds(request.getTagIds())
                .build());
    }

    @Override
    public MGetPostByIdResponse getPostById(String postId) {
        return postGrpcServiceBlockingStub.getPostById(IdRequest.newBuilder()
                        .setId(postId)
                .build());
    }
}

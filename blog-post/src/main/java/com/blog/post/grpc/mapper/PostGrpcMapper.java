package com.blog.post.grpc.mapper;

import com.blog.common.enums.PostStatus;
import com.blog.post.domain.entity.CdcUserEntity;
import com.blog.post.domain.entity.PostEntity;
import com.blog.post.domain.entity.PostTagEntity;
import com.blog.proto.mapper.GrpcMapper;
import com.daile.blog.post.MPost;
import com.daile.blog.post.MTags;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author daile
 * @since 12/06/2024
 */
@Component
public class PostGrpcMapper extends GrpcMapper<PostEntity, MPost, MPost.Builder> {

  @Override
  public MPost toGrpc(PostEntity input) {
    return toGrpcBuilder(input).build();
  }

  @Override
  public MPost.Builder toGrpcBuilder(PostEntity input) {
    return MPost.newBuilder()
        .setPostId(input.getPostId().toString())
        .setContent(input.getContent())
        .setUserId(input.getUserId().toString())
        .setTitle(input.getTitle())
        .setStatus(PostStatus.parse(input.getStatus()).getStatus());
  }

  public MPost toGrpc(PostEntity input, CdcUserEntity userEntity) {
    return toGrpcBuilder(input)
        .setFullName(
            Objects.nonNull(userEntity) ? StringUtils.defaultString(userEntity.getFullName()) : "")
        .build();
  }

  public List<MPost> toGrpc(List<PostEntity> inputs, Map<UUID, CdcUserEntity> userMap) {
    return inputs.stream().map(i -> toGrpc(i, userMap.get(i.getUserId()))).toList();
  }

  public MPost toGrpc(PostEntity input, List<PostTagEntity> postTag) {
    return toGrpcBuilder(input)
        .addAllTags(
            postTag.stream()
                .map(
                    pt ->
                        MTags.newBuilder()
                            .setTagName(pt.getTag().getName())
                            .setTagId(pt.getTag().getTagId().toString())
                            .setDescription(pt.getTag().getDescription())
                            .build())
                .toList())
        .build();
  }
}

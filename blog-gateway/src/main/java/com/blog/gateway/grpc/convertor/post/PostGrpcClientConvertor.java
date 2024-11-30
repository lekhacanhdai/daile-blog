package com.blog.gateway.grpc.convertor.post;

import com.blog.gateway.grpc.convertor.BaseResponse;
import com.blog.gateway.payload.response.Page;
import com.blog.gateway.payload.response.Response;
import com.blog.gateway.payload.response.post.PostDTO;
import com.blog.gateway.payload.response.post.TagDTO;
import com.daile.blog.post.MGetPostByIdResponse;
import com.daile.blog.post.MListPostResponse;
import com.daile.blog.post.MPost;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author daile
 * @since 10/06/2024
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostGrpcClientConvertor extends BaseResponse {
  public static Response<Page<PostDTO>> asSuccessResponse(MListPostResponse.Data data) {
    return Response.<Page<PostDTO>>newBuilder()
        .setSuccess(true)
        .setData(
            Page.<PostDTO>newBuilder()
                .setTotalPage(data.getPageable().getTotalPages())
                .setTotalElement(data.getPageable().getTotalElements())
                .setItems(
                    data.getPostsList().stream().map(PostGrpcClientConvertor::buildPost).toList())
                .build())
        .build();
  }

  public static Response<PostDTO> asSuccessResponse(MGetPostByIdResponse.Data data) {
    var post = data.getPost();
    return Response.<PostDTO>newBuilder().setSuccess(true).setData(buildPost(post)).build();
  }

  private static PostDTO buildPost(MPost mPost) {
    return PostDTO.newBuilder()
        .setPostId(mPost.getPostId())
        .setContent(mPost.getContent())
        .setStatus(mPost.getStatus())
        .setUserId(mPost.getUserId())
        .setFullName(mPost.getFullName())
        .setTitle(mPost.getTitle())
        .setTags(
            mPost.getTagsList().stream()
                .map(
                    t ->
                        TagDTO.newBuilder()
                            .setTagId(t.getTagId())
                            .setTagName(t.getTagName())
                            .setDescription(t.getDescription())
                            .build())
                .toList())
        .build();
  }
}

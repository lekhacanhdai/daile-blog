package com.blog.gateway.grpc.client.post;

import com.blog.gateway.payload.request.post.CreatePostRequest;
import com.blog.gateway.payload.request.post.ListPostRequest;
import com.daile.blog.post.MCreatePostResponse;
import com.daile.blog.post.MGetPostByIdResponse;
import com.daile.blog.post.MListPostResponse;

/**
 * @author daile
 * @since 10/06/2024
 */
public interface PostGrpcClientService {
    MListPostResponse listPost(ListPostRequest request);
    MCreatePostResponse createPost(CreatePostRequest request);
    MGetPostByIdResponse getPostById(String postId);
}

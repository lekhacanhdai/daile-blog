package com.blog.post.grpc.service;

import com.daile.blog.common.IdRequest;
import com.daile.blog.post.*;

/**
 * @author daile
 * @since 10/06/2024
 */
public interface PostGrpcService {
  MListPostResponse listPost(MListPostRequest request);

  MGetPostByIdResponse getPostById(IdRequest request);

  MCreatePostResponse createPost(MCreatePostRequest request);
}

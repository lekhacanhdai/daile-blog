package com.blog.post.grpc.service.impl;

import com.blog.post.grpc.service.PostGrpcService;
import com.daile.blog.common.IdRequest;
import com.daile.blog.post.*;
import org.springframework.stereotype.Service;

/**
 * @author daile
 * @since 10/06/2024
 */

@Service
public class PostGrpcServiceImpl implements PostGrpcService {
    @Override
    public MListPostResponse listPost(MListPostRequest request) {
        return null;
    }

    @Override
    public MGetPostByIdResponse getPostById(IdRequest request) {
        return null;
    }

    @Override
    public MCreatePostResponse createPost(MCreatePostRequest request) {
        return null;
    }
}

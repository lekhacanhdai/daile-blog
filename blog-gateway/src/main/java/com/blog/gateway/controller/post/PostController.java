package com.blog.gateway.controller.post;

import com.blog.gateway.grpc.client.post.PostGrpcClientService;
import com.blog.gateway.grpc.convertor.ErrorConvertor;
import com.blog.gateway.grpc.convertor.post.PostGrpcClientConvertor;
import com.blog.gateway.payload.request.post.CreatePostRequest;
import com.blog.gateway.payload.request.post.ListPostRequest;
import com.blog.gateway.payload.response.IdDTO;
import com.blog.gateway.payload.response.Page;
import com.blog.gateway.payload.response.Response;
import com.blog.gateway.payload.response.post.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author daile
 * @since 10/06/2024
 */

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostGrpcClientService postGrpcClientService;

    @GetMapping
    public Response<Page<PostDTO>> listPost(@ModelAttribute ListPostRequest request) {
        var grpcRes = postGrpcClientService.listPost(request);
        if (grpcRes.getSuccess()) {
            return PostGrpcClientConvertor.asSuccessResponse(grpcRes.getData());
        }
        return ErrorConvertor.asErrorResponse(grpcRes.getError());
    }

    @PostMapping
    public Response<IdDTO> createPost(@RequestBody CreatePostRequest request) {
        var grpcRes = postGrpcClientService.createPost(request);
        if (grpcRes.getSuccess()) {
            return PostGrpcClientConvertor.asSuccessResponse(grpcRes.getData());
        }
        return ErrorConvertor.asErrorResponse(grpcRes.getError());
    }

    @GetMapping("{id}")
    public Response<PostDTO> getPostById(@PathVariable(name = "id") String id) {
        var grpcRes = postGrpcClientService.getPostById(id);
        if (grpcRes.getSuccess()) {
            return PostGrpcClientConvertor.asSuccessResponse(grpcRes.getData());
        }
        return ErrorConvertor.asErrorResponse(grpcRes.getError());
    }

}

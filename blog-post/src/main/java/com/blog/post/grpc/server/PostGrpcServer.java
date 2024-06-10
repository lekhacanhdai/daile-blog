package com.blog.post.grpc.server;

import com.blog.post.grpc.service.PostGrpcService;
import com.blog.proto.utils.GrpcServerUtils;
import com.daile.blog.common.IdRequest;
import com.daile.blog.post.*;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author daile
 * @since 10/06/2024
 */

@GrpcService
@RequiredArgsConstructor
public class PostGrpcServer extends PostGrpcServiceGrpc.PostGrpcServiceImplBase {
    private final PostGrpcService postGrpcService;

    @Override
    public void createPost(MCreatePostRequest request, StreamObserver<MCreatePostResponse> responseObserver) {
        GrpcServerUtils.execute(request,
                responseObserver,
                postGrpcService::createPost,
                (e) -> MCreatePostResponse.newBuilder()
                        .setSuccess(false)
                        .setError(GrpcServerUtils.getError(e))
                        .build());
    }

    @Override
    public void listPost(MListPostRequest request, StreamObserver<MListPostResponse> responseObserver) {
        GrpcServerUtils.execute(request,
                responseObserver,
                postGrpcService::listPost,
                (e) -> MListPostResponse.newBuilder()
                        .setSuccess(false)
                        .setError(GrpcServerUtils.getError(e))
                        .build());
    }

    @Override
    public void getPostById(IdRequest request, StreamObserver<MGetPostByIdResponse> responseObserver) {
        GrpcServerUtils.execute(request,
                responseObserver,
                postGrpcService::getPostById,
                (e) -> MGetPostByIdResponse.newBuilder()
                        .setSuccess(false)
                        .setError(GrpcServerUtils.getError(e))
                        .build());
    }
}

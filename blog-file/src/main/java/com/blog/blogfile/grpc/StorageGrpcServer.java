package com.blog.blogfile.grpc;

import com.blog.blogfile.service.StorageService;
import com.blog.proto.utils.GrpcServerUtils;
import com.daile.blog.common.NoContentResponse;
import com.daile.blog.file.FileServiceGrpc;
import com.daile.blog.file.UploadFileRequest;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author daile
 * @since 27/07/2024
 */

@GrpcService
@RequiredArgsConstructor
public class StorageGrpcServer extends FileServiceGrpc.FileServiceImplBase {
    private final StorageService storageService;
    @Override
    public void uploadFile(UploadFileRequest request, StreamObserver<NoContentResponse> responseObserver) {
        GrpcServerUtils.execute(request,
                responseObserver,
                storageService::uploadFile,
                (e) -> NoContentResponse.newBuilder()
                        .setSuccess(false)
                        .setError(GrpcServerUtils.getError(e))
                        .build());
    }
}

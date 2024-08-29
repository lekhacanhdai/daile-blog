package com.blog.gateway.grpc.client.file.impl;

import com.blog.gateway.grpc.client.file.FileGrpcClientService;
import com.daile.blog.common.NoContentResponse;
import com.daile.blog.file.FileServiceGrpc;
import com.daile.blog.file.UploadFileRequest;
import com.google.protobuf.ByteString;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author daile
 * @since 28/08/2024
 */

@Service
@RequiredArgsConstructor
public class FileGrpcClientServiceImpl implements FileGrpcClientService {
    private final FileServiceGrpc.FileServiceBlockingStub fileServiceBlockingStub;
    @Override
    public NoContentResponse uploadFile(MultipartFile file) {
        ByteString fileData;
        try {
            fileData = ByteString.copyFrom(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert file to byte array", e);
        }
        return fileServiceBlockingStub.uploadFile(UploadFileRequest.newBuilder()
                        .setFileName(file.getName())
                        .setContentType(file.getContentType())
                        .setData(fileData)
                .build());
    }
}

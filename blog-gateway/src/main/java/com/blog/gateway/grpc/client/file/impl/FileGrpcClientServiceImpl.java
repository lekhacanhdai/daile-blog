package com.blog.gateway.grpc.client.file.impl;

import com.blog.gateway.grpc.client.file.FileGrpcClientService;
import com.daile.blog.file.FileServiceGrpc;
import com.daile.blog.file.UploadFileRequest;
import com.daile.blog.file.UploadFileResponse;
import com.google.protobuf.ByteString;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author daile
 * @since 28/08/2024
 */
@Service
@RequiredArgsConstructor
public class FileGrpcClientServiceImpl implements FileGrpcClientService {
  private final FileServiceGrpc.FileServiceBlockingStub fileServiceBlockingStub;

  @Override
  public UploadFileResponse uploadFile(MultipartFile file) {
    ByteString fileData;
    try {
      fileData = ByteString.copyFrom(file.getBytes());
    } catch (IOException e) {
      throw new RuntimeException("Failed to convert file to byte array", e);
    }
    return fileServiceBlockingStub.uploadFile(
        UploadFileRequest.newBuilder()
            .setFileName(file.getOriginalFilename())
            .setContentType(file.getContentType())
            .setData(fileData)
            .build());
  }
}

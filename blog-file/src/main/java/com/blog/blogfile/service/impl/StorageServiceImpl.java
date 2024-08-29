package com.blog.blogfile.service.impl;

import com.blog.blogfile.service.StorageService;
import com.daile.blog.common.Empty;
import com.daile.blog.common.NoContentResponse;
import com.daile.blog.file.UploadFileRequest;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

/**
 * @author daile
 * @since 27/07/2024
 */

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {
    private final MinioClient minioClient;
    private final Environment environment;
    @Override
    public NoContentResponse uploadFile(UploadFileRequest request) {
        try {
            var inputStream = new ByteArrayInputStream(request.getData().toByteArray());
            minioClient.putObject(PutObjectArgs.builder()
                            .bucket(environment.getRequiredProperty("minio.bucket.name"))
                            .contentType(request.getContentType())
                            .object(request.getFileName())
                            .stream(inputStream, inputStream.available(), -1)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException("Error occurred: " + e.getMessage());
        }
        return NoContentResponse.newBuilder()
                .setSuccess(true)
                .setEmpty(Empty.newBuilder().build())
                .build();
    }
}

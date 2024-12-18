package com.blog.blogfile.service.impl;

import com.blog.blogfile.service.StorageService;
import com.daile.blog.file.UploadFileRequest;
import com.daile.blog.file.UploadFileResponse;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import java.io.ByteArrayInputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @author daile
 * @since 27/07/2024
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class StorageServiceImpl implements StorageService {
  private final MinioClient minioClient;
  private final Environment environment;

  @Override
  public UploadFileResponse uploadFile(UploadFileRequest request) {
    try {
      var inputStream = new ByteArrayInputStream(request.getData().toByteArray());
      var res =
          minioClient.putObject(
              PutObjectArgs.builder()
                  .bucket(environment.getRequiredProperty("minio.bucket.name"))
                  .contentType(request.getContentType())
                  .object(generatedFileName(request.getFileName()))
                  .stream(inputStream, inputStream.available(), -1)
                  .build());
      return UploadFileResponse.newBuilder()
          .setSuccess(true)
          .setData(UploadFileResponse.Data.newBuilder().setPath(res.object()).build())
          .build();
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  private String generatedFileName(String originalFileName) {
    int dotIndex = originalFileName.lastIndexOf('.');
    if (dotIndex == -1 || dotIndex == 0 || dotIndex == originalFileName.length() - 1) {
      throw new IllegalArgumentException("Invalid file name format");
    }
    String baseName = originalFileName.substring(0, dotIndex);
    String extension = originalFileName.substring(dotIndex); // Includes the dot (.)
    return baseName + System.currentTimeMillis() + extension;
  }
}

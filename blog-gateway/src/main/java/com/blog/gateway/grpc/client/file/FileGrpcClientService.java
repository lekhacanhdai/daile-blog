package com.blog.gateway.grpc.client.file;

import com.daile.blog.file.UploadFileResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author daile
 * @since 28/08/2024
 */
public interface FileGrpcClientService {
  UploadFileResponse uploadFile(MultipartFile file);
}

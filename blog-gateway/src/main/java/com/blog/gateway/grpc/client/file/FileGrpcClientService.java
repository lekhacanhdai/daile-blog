package com.blog.gateway.grpc.client.file;

import com.daile.blog.common.NoContentResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author daile
 * @since 28/08/2024
 */
public interface FileGrpcClientService {
    NoContentResponse uploadFile(MultipartFile file);
}

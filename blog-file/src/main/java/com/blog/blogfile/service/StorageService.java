package com.blog.blogfile.service;

import com.daile.blog.common.NoContentResponse;
import com.daile.blog.file.UploadFileRequest;

/**
 * @author daile
 * @since 27/07/2024
 */
public interface StorageService {
    NoContentResponse uploadFile(UploadFileRequest request);
}

package com.blog.blogfile.service;

import com.daile.blog.file.UploadFileRequest;
import com.daile.blog.file.UploadFileResponse;

/**
 * @author daile
 * @since 27/07/2024
 */
public interface StorageService {
    UploadFileResponse uploadFile(UploadFileRequest request);
}

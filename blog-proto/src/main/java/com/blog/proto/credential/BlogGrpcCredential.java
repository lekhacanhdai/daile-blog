package com.blog.proto.credential;

import io.grpc.CallCredentials;

import java.util.concurrent.Executor;

/**
 * @author daile
 * @since 14/06/2024
 */

public class BlogGrpcCredential extends CallCredentials {
    @Override
    public void applyRequestMetadata(RequestInfo requestInfo, Executor appExecutor, MetadataApplier applier) {
        appExecutor.execute(() -> {

        });
    }
}

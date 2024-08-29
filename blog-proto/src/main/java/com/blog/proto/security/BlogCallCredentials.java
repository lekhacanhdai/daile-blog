package com.blog.proto.security;

import com.blog.proto.credential.BlogGrpcCredential;
import io.grpc.CallCredentials;
import io.grpc.Metadata;
import io.grpc.Status;
import lombok.AllArgsConstructor;

import java.util.concurrent.Executor;

/**
 * @author daile
 * @since 23/06/2024
 */
@AllArgsConstructor
public class BlogCallCredentials extends CallCredentials {
    private final BlogPrincipal blogPrincipal;

    @Override
    public void applyRequestMetadata(RequestInfo requestInfo, Executor appExecutor, MetadataApplier applier) {
        appExecutor.execute(() -> {
            try {
                var jwt = BlogPrincipalProvider.buildJwt(blogPrincipal);
                Metadata headers = new Metadata();
                headers.put(GrpcConstant.AUTHORIZATION_METADATA_KEY, String.format("%s %s", GrpcConstant.BEARER_TYPE, jwt));
                applier.apply(headers);
            } catch (Throwable e) {
                applier.fail(Status.UNAUTHENTICATED.withCause(e));
            }
        });
    }
}

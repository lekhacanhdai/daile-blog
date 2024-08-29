package com.blog.proto.security;

import io.grpc.Context;
import io.grpc.Metadata;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author daile
 * @since 23/06/2024
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GrpcConstant {
    public static final String JWT_SIGNING_KEY = "L8hHXsaQdOUjk5rNg7XPGv4eL36anlCrkMz8CJ0i/8E/0=";
    public static final String BEARER_TYPE = "Bearer";

    public static final Metadata.Key<String> AUTHORIZATION_METADATA_KEY = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);
    public static final Context.Key<BlogPrincipal> CLIENT_ID_CONTEXT_KEY = Context.key("blog_grpc_context_key");
}

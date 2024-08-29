package com.blog.proto.security;

import io.grpc.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

/**
 * @author daile
 * @since 23/06/2024
 */
public class AuthorizationServerInterceptor implements ServerInterceptor {

    private final JwtParser parser = Jwts.parser().setSigningKey(GrpcConstant.JWT_SIGNING_KEY).build();

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        String value = metadata.get(GrpcConstant.AUTHORIZATION_METADATA_KEY);

        Status status;
        if (value == null) {
            status = Status.UNAUTHENTICATED.withDescription("Authorization token is missing");
        } else if (!value.startsWith(GrpcConstant.BEARER_TYPE)) {
            status = Status.UNAUTHENTICATED.withDescription("Unknown authorization type");
        } else {
            try {
                String token = value.substring(GrpcConstant.BEARER_TYPE.length()).trim();
                Jws<Claims> claims = parser.parseSignedClaims(token);
                var principal = BlogPrincipalProvider.reBuildPrincipalFromJwt(claims.getPayload());
                Context ctx = Context.current().withValue(GrpcConstant.CLIENT_ID_CONTEXT_KEY, principal);
                return Contexts.interceptCall(ctx, serverCall, metadata, serverCallHandler);
            } catch (Exception e) {
                status = Status.UNAUTHENTICATED.withDescription(e.getMessage()).withCause(e);
            }
        }

        return serverCallHandler.startCall(serverCall, metadata);

//        serverCall.close(status, metadata);
//        return new ServerCall.Listener<>() {
//            // noop
//        };
    }
}
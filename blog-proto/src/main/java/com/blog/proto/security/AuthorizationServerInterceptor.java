package com.blog.proto.security;

import io.grpc.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import lombok.extern.log4j.Log4j2;

/**
 * @author daile
 * @since 23/06/2024
 */
@Log4j2
public class AuthorizationServerInterceptor implements ServerInterceptor {

  private final JwtParser parser =
      Jwts.parser().setSigningKey(GrpcConstant.JWT_SIGNING_KEY).build();

  @Override
  public <R, S> ServerCall.Listener<R> interceptCall(
      ServerCall<R, S> serverCall, Metadata metadata, ServerCallHandler<R, S> serverCallHandler) {
    String value = metadata.get(GrpcConstant.AUTHORIZATION_METADATA_KEY);

    if (value != null && value.startsWith(GrpcConstant.BEARER_TYPE)) {
      try {
        String token = value.substring(GrpcConstant.BEARER_TYPE.length()).trim();
        Jws<Claims> claims = parser.parseSignedClaims(token);
        var principal = BlogPrincipalProvider.reBuildPrincipalFromJwt(claims.getPayload());
        Context ctx = Context.current().withValue(GrpcConstant.CLIENT_ID_CONTEXT_KEY, principal);
        return Contexts.interceptCall(ctx, serverCall, metadata, serverCallHandler);
      } catch (Exception e) {
        log.debug(e.getMessage());
      }
    }

    return serverCallHandler.startCall(serverCall, metadata);
  }
}

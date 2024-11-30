package com.blog.proto.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author daile
 * @since 22/06/2024
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BlogPrincipalProvider {
  public static BlogCallCredentials asGrpcCredentials(BlogPrincipal principal) {
    return new BlogCallCredentials(principal);
  }

  public static String buildJwt(BlogPrincipal blogPrincipal) {
    var now = new Timestamp(System.currentTimeMillis());
    var additionalInformation = new HashMap<String, Object>();
    additionalInformation.put("user_id", blogPrincipal.getUserId());
    additionalInformation.put("username", blogPrincipal.getUsername());
    additionalInformation.put("roles", blogPrincipal.getRoles());
    return Jwts.builder()
        .subject(blogPrincipal.getUserId())
        .issuedAt(now)
        .notBefore(now)
        .expiration(new Timestamp(System.currentTimeMillis() + 1000 * 60 * 5))
        .claims(additionalInformation)
        .signWith(SignatureAlgorithm.HS256, GrpcConstant.JWT_SIGNING_KEY)
        .compact();
  }

  public static BlogPrincipal reBuildPrincipalFromJwt(Claims claims) {
    return BlogPrincipal.newBuilder()
        .setUserId(claims.get("user_id", String.class))
        .setUsername(claims.get("username", String.class))
        .setRoles(claims.get("roles", List.class))
        .build();
  }
}

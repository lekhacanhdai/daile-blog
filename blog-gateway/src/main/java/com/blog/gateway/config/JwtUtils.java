package com.blog.gateway.config;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

/**
 * @author daile
 * @since 22/06/2024
 */
@SuppressWarnings("ALL")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtUtils {
  public static CustomAuthenticationToken createJwtUser(Jwt jwt) {
    var rawRoles = (List<String>) jwt.getClaims().get("roles");
    Set<SimpleGrantedAuthority> roles =
        rawRoles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    return new CustomAuthenticationToken(jwt, roles, jwt.getClaims());
  }
}

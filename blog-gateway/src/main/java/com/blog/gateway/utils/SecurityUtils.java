package com.blog.gateway.utils;

import com.blog.proto.security.BlogPrincipal;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author daile
 * @since 23/06/2024
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityUtils {
  public static BlogPrincipal getPrincipal() {
    var auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null && auth.getPrincipal() instanceof BlogPrincipal principal) {
      return principal;
    }
    return null;
  }
}

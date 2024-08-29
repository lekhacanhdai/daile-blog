package com.blog.gateway.utils;

import com.blog.proto.security.BlogPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author daile
 * @since 23/06/2024
 */

public class SecurityUtils {
    public static BlogPrincipal getPrincipal() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            if (auth.getPrincipal() instanceof BlogPrincipal principal) {
                return principal;
            }
        }
        return null;
    }
}

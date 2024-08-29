package com.blog.gateway.config;

import com.blog.proto.security.BlogPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;
import java.util.Map;

/**
 * @author daile
 * @since 23/06/2024
 */

public class CustomAuthenticationToken extends JwtAuthenticationToken {
    /**
     * Creates a token with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     */
    private final Map<String, Object> claims;

    public CustomAuthenticationToken(Jwt jwt, Collection<? extends GrantedAuthority> authorities, Map<String, Object> claims) {
        super(jwt, authorities);
        this.claims = claims;
    }


    @Override
    public Object getCredentials() {
        return claims.get("user_id");
    }

    @Override
    public Object getPrincipal() {
        return BlogPrincipal.newBuilder()
                .setUsername(claims.get(JwtClaimNames.SUB).toString())
                .setUserId(claims.get("user_id").toString())
                .setRoles(getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .build();
    }
}

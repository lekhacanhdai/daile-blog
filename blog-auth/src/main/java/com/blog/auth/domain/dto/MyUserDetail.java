package com.blog.auth.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author dai.le-anh
 * @since 3/18/2024
 */

@Getter
@Setter
public class MyUserDetail extends User implements Serializable {
    private String userId;
    private String email;
    private Integer status;
    private String fullName;

    public MyUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}

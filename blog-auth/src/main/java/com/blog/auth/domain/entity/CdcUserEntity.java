package com.blog.auth.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

/**
 * @author dai.le-anh
 * @since 3/18/2024
 */

@Entity
@Table(name = "cdc_account_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CdcUserEntity {
    @Id
    @Column(name = "user_id")
    private UUID userId;

    private String username;

    private String password;

    private String email;

    private Integer status;

    @Column(name = "full_name")
    private String fullName;

    @ManyToMany
    @JoinTable(
            name = "cdc_account_user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<CdcRoleEntity> roles;
}

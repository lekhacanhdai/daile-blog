package com.blog.post.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @author daile
 * @since 10/06/2024
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
}


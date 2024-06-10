package com.blog.auth.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @author dai.le-anh
 * @since 3/18/2024
 */

@Entity
@Table(name = "cdc_account_user_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CdcUserRoleEntity {
    @Id
    @Column(name = "user_role_id")
    private UUID userRoleId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private CdcUserEntity user;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private CdcRoleEntity role;
}

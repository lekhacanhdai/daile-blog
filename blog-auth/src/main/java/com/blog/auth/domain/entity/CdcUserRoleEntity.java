package com.blog.auth.domain.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dai.le-anh
 * @since 3/18/2024
 */
@Entity
@Table(name = "user_role")
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

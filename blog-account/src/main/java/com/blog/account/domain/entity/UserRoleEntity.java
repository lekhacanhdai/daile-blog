package com.blog.account.domain.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author daile
 * @since 26/05/2024
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_role")
public class UserRoleEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_role_id")
  private UUID userRoleId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", referencedColumnName = "user_id")
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id", referencedColumnName = "role_id")
  private RoleEntity role;
}

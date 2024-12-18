package com.blog.auth.domain.entity;

import jakarta.persistence.*;
import java.util.Set;
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
@Table(name = "users")
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
      name = "user_role",
      joinColumns = @JoinColumn(name = "role_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
  private Set<CdcRoleEntity> roles;
}

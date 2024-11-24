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
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "role_id")
  private UUID roleId;

  @Column(name = "role", nullable = false)
  private String role;

  @Column(name = "description")
  private String description;

  @Column(name = "status")
  private Integer status = 0;
}

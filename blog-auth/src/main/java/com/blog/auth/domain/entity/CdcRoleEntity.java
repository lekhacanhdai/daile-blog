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
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CdcRoleEntity {
  @Id
  @Column(name = "role_id")
  private UUID roleId;

  private String role;

  private String description;

  private Integer status;
}

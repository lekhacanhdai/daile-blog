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
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends CommonEntity<UUID> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private UUID userId;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "full_name", nullable = false)
  private String fullName;

  @Column(name = "status")
  private Integer status = 0;
}

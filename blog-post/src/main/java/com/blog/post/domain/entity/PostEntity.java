package com.blog.post.domain.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author daile
 * @since 10/06/2024
 */
@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "post_id")
  private UUID postId;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "content", nullable = false)
  private String content;

  @Column(name = "user_id", nullable = false)
  private UUID userId;

  @Column(name = "status", nullable = false)
  private Integer status = 0;
}

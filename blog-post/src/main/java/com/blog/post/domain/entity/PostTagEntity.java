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
@Table(name = "post_tag")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostTagEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "post_tag_id")
  private UUID postTagId;

  @ManyToOne
  @JoinColumn(name = "post_id", referencedColumnName = "post_id")
  private PostEntity post;

  @ManyToOne
  @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
  private TagEntity tag;
}

package com.blog.gateway.payload.request.post;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author daile
 * @since 10/06/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {
  private String title;
  private String content;
  private String status;
  private List<String> tagIds;
}

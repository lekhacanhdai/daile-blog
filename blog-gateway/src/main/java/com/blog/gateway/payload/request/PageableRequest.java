package com.blog.gateway.payload.request;

import lombok.*;

/**
 * @author daile
 * @since 02/06/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageableRequest {
  private Long page;
  private Long size;
  private String sort;
  private String direction;
  private Boolean ignorePage;
}

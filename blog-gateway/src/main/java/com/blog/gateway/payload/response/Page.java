package com.blog.gateway.payload.response;

import java.util.List;
import lombok.*;

/**
 * @author daile
 * @since 02/06/2024
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "set", builderMethodName = "newBuilder")
public class Page<T> {
  private List<T> items;
  private Long totalElement;
  private Long totalPage;
}

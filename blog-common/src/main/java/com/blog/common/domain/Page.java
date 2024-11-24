package com.blog.common.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author daile
 * @since 01/06/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
  private List<T> items;
  private Long totalElement;
}

package com.blog.common.enums;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author daile
 * @since 12/06/2024
 */
@AllArgsConstructor
@Getter
public enum PostStatus {
  DRAFT(1, "DRAFT"),
  PUBLISH(2, "PUBLISH"),
  DISABLE(3, "DISABLE");
  private final Integer id;
  private final String status;

  public static PostStatus parse(Integer id) {
    return Arrays.stream(values()).filter(s -> s.id.equals(id)).findFirst().orElse(DRAFT);
  }
}

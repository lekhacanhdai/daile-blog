package com.blog.common.enums;

import java.util.Arrays;

/**
 * @author daile
 * @since 26/05/2024
 */
public enum Role {
  USER,
  ADMIN;

  public static boolean isValid(String role) {
    return Arrays.stream(values()).anyMatch(v -> v.name().equals(role));
  }

  public static String parse(String role) {
    return Arrays.stream(values())
        .filter(r -> r.name().equals(role))
        .findFirst()
        .orElse(USER)
        .name();
  }
}

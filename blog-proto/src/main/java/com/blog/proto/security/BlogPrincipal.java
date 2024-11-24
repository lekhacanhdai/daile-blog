package com.blog.proto.security;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author daile
 * @since 23/06/2024
 */
@Getter
@Setter
@Builder(setterPrefix = "set", builderMethodName = "newBuilder")
public class BlogPrincipal {
  private String username;
  private String userId;
  private List<String> roles;
}

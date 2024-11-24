package com.blog.gateway.payload.response.account;

import java.util.UUID;
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
public class UserDTO {
  private UUID userId;
  private String username;
  private String fullName;
  private String email;
}

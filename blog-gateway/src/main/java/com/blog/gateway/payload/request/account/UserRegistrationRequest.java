package com.blog.gateway.payload.request.account;

import lombok.Builder;
import lombok.Data;

/**
 * @author daile
 * @since 08/06/2024
 */


@Data
@Builder(setterPrefix = "set", builderMethodName = "newBuilder")
public class UserRegistrationRequest {
    private String username;
    private String password;
    private String email;
    private String fullName;
}

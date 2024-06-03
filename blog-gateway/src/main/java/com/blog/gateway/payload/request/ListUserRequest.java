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
@Builder(setterPrefix = "set", builderMethodName = "newBuilder")
public class ListUserRequest extends PageableRequest{
    private String searchTerm;
}

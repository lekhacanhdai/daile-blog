package com.blog.gateway.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class Response<T> {
    private boolean success;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Error error;
}

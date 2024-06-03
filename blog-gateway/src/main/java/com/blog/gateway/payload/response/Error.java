package com.blog.gateway.payload.response;

import lombok.*;

import java.util.List;

/**
 * @author daile
 * @since 02/06/2024
 */

@Getter
@Setter
@Builder(setterPrefix = "set", builderMethodName = "newBuilder")
@AllArgsConstructor
@NoArgsConstructor
public class Error {
    private String code;
    private List<ErrorDetail> details;

    @Getter
    @Setter
    @Builder(setterPrefix = "set", builderMethodName = "newBuilder")
    @AllArgsConstructor
    @NoArgsConstructor

    public static class ErrorDetail {
        private String code;
        private String message;
    }
}

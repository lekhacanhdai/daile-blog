package com.blog.gateway.grpc.convertor;

import com.blog.gateway.payload.response.Error;
import com.blog.gateway.payload.response.Response;
import com.daile.blog.common.GrpcError;

/**
 * @author daile
 * @since 02/06/2024
 */
public class ErrorConvertor {
    public static <T> Response<T> asErrorResponse(GrpcError error) {
        return Response.<T>newBuilder()
                .setSuccess(false)
                .setError(Error.newBuilder()
                        .setCode(error.getCode().name())
                        .setDetails(error.getDetailsList().stream()
                                .map(e -> Error.ErrorDetail.newBuilder()
                                        .setCode(e.getCode())
                                        .setMessage(e.getMessage())
                                        .build())
                                .toList())
                        .build())
                .build();
    }
}

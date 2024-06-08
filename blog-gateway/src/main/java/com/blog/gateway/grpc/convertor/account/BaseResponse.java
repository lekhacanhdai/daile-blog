package com.blog.gateway.grpc.convertor.account;

import com.blog.gateway.payload.response.IdDTO;
import com.blog.gateway.payload.response.Response;
import com.daile.blog.common.IdResponse;

/**
 * @author daile
 * @since 08/06/2024
 */
public abstract class BaseResponse {
    public static Response<IdDTO> asSuccessResponse(IdResponse response) {
        return Response.<IdDTO>newBuilder()
                .setSuccess(true)
                .setData(IdDTO.builder()
                        .id(response.getId())
                        .build())
                .build();
    }
}

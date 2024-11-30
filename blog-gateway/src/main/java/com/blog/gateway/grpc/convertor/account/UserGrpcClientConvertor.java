package com.blog.gateway.grpc.convertor.account;

import com.blog.gateway.grpc.convertor.BaseResponse;
import com.blog.gateway.payload.response.Page;
import com.blog.gateway.payload.response.Response;
import com.blog.gateway.payload.response.account.UserDTO;
import com.daile.blog.account.ListUserResponse;
import java.util.UUID;

public class UserGrpcClientConvertor extends BaseResponse {
  public static Response<Page<UserDTO>> asSuccessResponse(ListUserResponse.Data data) {
    return Response.<Page<UserDTO>>newBuilder()
        .setSuccess(true)
        .setData(
            Page.<UserDTO>newBuilder()
                .setItems(
                    data.getUsersList().stream()
                        .map(
                            user ->
                                UserDTO.newBuilder()
                                    .setUserId(user.getUserId().transform(UUID::fromString))
                                    .setEmail(user.getEmail())
                                    .setFullName(user.getFullName())
                                    .setUsername(user.getUsername())
                                    .build())
                        .toList())
                .setTotalElement(data.getPageable().getTotalElements())
                .setTotalPage(data.getPageable().getTotalPages())
                .build())
        .build();
  }
}

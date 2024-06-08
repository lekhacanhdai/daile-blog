package com.blog.gateway.grpc.client.account.impl;

import com.blog.gateway.grpc.client.account.UserGrpcClientService;
import com.blog.gateway.grpc.utils.PageUtils;
import com.blog.gateway.payload.request.ListUserRequest;
import com.blog.gateway.payload.request.UserRegistrationRequest;
import com.daile.blog.account.ListUserResponse;
import com.daile.blog.account.UserGrpcServiceGrpc;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author daile
 * @since 02/06/2024
 */

@Service
@RequiredArgsConstructor
public class UserGrpcClientServiceImpl implements UserGrpcClientService {
    private final UserGrpcServiceGrpc.UserGrpcServiceBlockingStub userGrpcServiceBlockingStub;

    @Override
    public ListUserResponse listUser(ListUserRequest request) {
        return userGrpcServiceBlockingStub.listUser(com.daile.blog.account.ListUserRequest.newBuilder()
                        .setSearchTerm(StringUtils.defaultString(request.getSearchTerm()))
                        .setPageable(PageUtils.toGrpcPageable(request))
                .build());
    }

    @Override
    public UserRegistrationResponse userRegistration(UserRegistrationRequest request) {
        return userGrpcServiceBlockingStub.userRegistration(com.daile.blog.account.UserRegistrationRequest.newBuilder()
                        .setEmail(request.getEmail())
                        .setPassword(request.getPassword())
                        .setFullName(request.getFullName())
                        .setUsername(request.getUsername())
                .build());
    }
}

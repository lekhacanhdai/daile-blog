package com.blog.gateway.grpc.client.account;

import com.blog.gateway.payload.request.ListUserRequest;
import com.daile.blog.account.ListUserResponse;

/**
 * @author daile
 * @since 02/06/2024
 */

public interface UserGrpcClientService {
    ListUserResponse listUser(ListUserRequest request);
}

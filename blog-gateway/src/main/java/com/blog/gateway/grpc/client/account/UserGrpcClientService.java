package com.blog.gateway.grpc.client.account;

import com.blog.gateway.payload.request.account.ListUserRequest;
import com.blog.gateway.payload.request.account.UserRegistrationRequest;
import com.daile.blog.account.ListUserResponse;
import com.daile.blog.account.UserRegistrationResponse;

/**
 * @author daile
 * @since 02/06/2024
 */
public interface UserGrpcClientService {
  ListUserResponse listUser(ListUserRequest request);

  UserRegistrationResponse userRegistration(UserRegistrationRequest request);
}

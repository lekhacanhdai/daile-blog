package com.blog.account.grpc.service;

import com.daile.blog.account.*;
import com.daile.blog.common.IdRequest;

/**
 * @author daile
 * @since 26/05/2024
 */
public interface UserGrpcService {
  UserRegistrationResponse createUser(UserRegistrationRequest request);

  ListUserResponse listUser(ListUserRequest request);

  GetUserByIdResponse getUserById(IdRequest request);
}

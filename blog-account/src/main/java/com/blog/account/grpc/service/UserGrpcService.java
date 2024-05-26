package com.blog.account.grpc.service;

import com.daile.blog.account.GetUserByIdResponse;
import com.daile.blog.account.ListUserRequest;
import com.daile.blog.account.ListUserResponse;
import com.daile.blog.account.UserRegistrationRequest;
import com.daile.blog.common.IdRequest;
import com.daile.blog.common.IdResponse;

/**
 * @author daile
 * @since 26/05/2024
 */
public interface UserGrpcService {
    IdResponse createUser(UserRegistrationRequest request);
    ListUserResponse listUser(ListUserRequest request);
    GetUserByIdResponse getUserById(IdRequest request);
}

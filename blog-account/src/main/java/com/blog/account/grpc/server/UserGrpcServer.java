package com.blog.account.grpc.server;

import com.blog.account.grpc.service.UserGrpcService;
import com.blog.proto.utils.GrpcServerUtils;
import com.daile.blog.account.*;
import com.daile.blog.common.*;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author daile
 * @since 26/05/2024
 */
@GrpcService
@RequiredArgsConstructor
public class UserGrpcServer extends UserGrpcServiceGrpc.UserGrpcServiceImplBase {

  private final UserGrpcService userGrpcService;

  @Override
  public void userRegistration(
      UserRegistrationRequest request, StreamObserver<UserRegistrationResponse> responseObserver) {
    GrpcServerUtils.execute(
        request,
        responseObserver,
        userGrpcService::createUser,
        (e) ->
            UserRegistrationResponse.newBuilder()
                .setSuccess(false)
                .setError(GrpcServerUtils.getError(e))
                .build());
  }

  @Override
  public void getUserById(IdRequest request, StreamObserver<GetUserByIdResponse> responseObserver) {
    GrpcServerUtils.execute(
        request,
        responseObserver,
        userGrpcService::getUserById,
        (e) ->
            GetUserByIdResponse.newBuilder()
                .setSuccess(false)
                .setError(GrpcServerUtils.getError(e))
                .build());
  }

  @Override
  public void listUser(ListUserRequest request, StreamObserver<ListUserResponse> responseObserver) {
    GrpcServerUtils.execute(
        request,
        responseObserver,
        userGrpcService::listUser,
        (e) ->
            ListUserResponse.newBuilder()
                .setSuccess(false)
                .setError(GrpcServerUtils.getError(e))
                .build());
  }
}

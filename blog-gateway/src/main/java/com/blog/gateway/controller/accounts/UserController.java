package com.blog.gateway.controller.accounts;

import com.blog.gateway.grpc.client.account.UserGrpcClientService;
import com.blog.gateway.grpc.convertor.account.ErrorConvertor;
import com.blog.gateway.grpc.convertor.account.UserGrpcClientConvertor;
import com.blog.gateway.payload.request.ListUserRequest;
import com.blog.gateway.payload.request.UserRegistrationRequest;
import com.blog.gateway.payload.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

/**
 * @author daile
 * @since 02/06/2024
 */

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserGrpcClientService userGrpcClientService;

    @PostMapping("/registration")
    public Response<IdDTO> userRegistration(@RequestBody UserRegistrationRequest request) {
        var grpcRes = userGrpcClientService.userRegistration(request);
        if (grpcRes.getSuccess()) {
            return UserGrpcClientConvertor.asSuccessResponse(grpcRes.getData());
        } else {
            return ErrorConvertor.asErrorResponse(grpcRes.getError());
        }
    }

    @GetMapping
    @Secured({"USER", "ADMIN"})
    public Response<Page<UserDTO>> listUser(@ModelAttribute ListUserRequest request) {
        var grpcRes = userGrpcClientService.listUser(request);
        if (grpcRes.getSuccess()) {
            return UserGrpcClientConvertor.asSuccessResponse(grpcRes.getData());
        } else {
            return ErrorConvertor.asErrorResponse(grpcRes.getError());
        }
    }
}

package com.blog.gateway.controller.accounts;

import com.blog.gateway.grpc.client.account.UserGrpcClientService;
import com.blog.gateway.grpc.convertor.account.ErrorConvertor;
import com.blog.gateway.grpc.convertor.account.UserGrpcClientConvertor;
import com.blog.gateway.payload.request.ListUserRequest;
import com.blog.gateway.payload.response.Page;
import com.blog.gateway.payload.response.Response;
import com.blog.gateway.payload.response.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

/**
 * @author daile
 * @since 02/06/2024
 */

@RestController
@RequestMapping("/users")
@Secured({"USER", "ADMIN"})
@RequiredArgsConstructor
public class UserController {
    private final UserGrpcClientService userGrpcClientService;

    @GetMapping
    public Response<Page<UserDTO>> listUser(@ModelAttribute ListUserRequest request) {
        var grpcRes = userGrpcClientService.listUser(request);
        if (grpcRes.getSuccess()) {
            return UserGrpcClientConvertor.asGrpcResponse(grpcRes.getData());
        } else {
            return ErrorConvertor.asErrorResponse(grpcRes.getError());
        }
    }
}

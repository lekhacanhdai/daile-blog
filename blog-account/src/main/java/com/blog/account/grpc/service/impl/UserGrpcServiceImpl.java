package com.blog.account.grpc.service.impl;

import com.blog.account.domain.entity.UserEntity;
import com.blog.account.domain.entity.UserRoleEntity;
import com.blog.account.domain.prefetch.PrefetchEntityProvider;
import com.blog.account.domain.repository.UserRepository;
import com.blog.account.domain.repository.UserRoleRepository;
import com.blog.account.domain.repository.dsl.UserDslRepository;
import com.blog.account.grpc.mapper.UserMapper;
import com.blog.account.grpc.service.UserGrpcService;
import com.blog.account.validator.UserValidator;
import com.blog.common.enums.Role;
import com.blog.common.enums.UserStatus;
import com.blog.proto.exception.GrpcNotFoundException;
import com.blog.proto.utils.PageableUtils;
import com.daile.blog.account.*;
import com.daile.blog.common.IdRequest;
import com.daile.blog.common.IdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author daile
 * @since 26/05/2024
 */

@Service
@RequiredArgsConstructor
public class UserGrpcServiceImpl implements UserGrpcService {
    private final UserValidator userValidator;

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserDslRepository userDslRepository;

    private final PrefetchEntityProvider prefetchEntityProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserRegistrationResponse createUser(UserRegistrationRequest request) {
        var res = UserRegistrationResponse.newBuilder();
        var validateSuccess = userValidator.validateUserRegistration(request, res);
        if (!validateSuccess){
            return res.setSuccess(false)
                    .build();
        }

        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setStatus(UserStatus.ACTIVE.getId());
        user.setFullName(request.getFullName());
        var savedUser = userRepository.save(user);

        UserRoleEntity userRole = new UserRoleEntity();
        userRole.setRole(prefetchEntityProvider.getRoleMapName().get(Role.USER.name()));
        userRole.setUser(savedUser);
        userRoleRepository.save(userRole);
        return UserRegistrationResponse.newBuilder()
                .setSuccess(true)
                .setData(IdResponse.newBuilder()
                        .setId(savedUser.getUserId().toString())
                        .build())
                .build();
    }

    @Override
    public ListUserResponse listUser(ListUserRequest request) {
        var pageUser = userDslRepository.listUser(request);
        return ListUserResponse.newBuilder()
                .setSuccess(true)
                .setData(ListUserResponse.Data.newBuilder()
                        .addAllUsers(userMapper.toGrpc(pageUser.getItems()))
                        .setPageable(PageableUtils.normalize(request.getPageable(), pageUser.getTotalElement()))
                        .build())
                .build();
    }

    @Override
    public GetUserByIdResponse getUserById(IdRequest request) {
        var user = userRepository.findById(request.getId().transform(UUID::fromString))
                .orElseThrow(() -> new GrpcNotFoundException("User not found with id " + request.getId()));
        return GetUserByIdResponse.newBuilder()
                .setData(GetUserByIdResponse.Data.newBuilder()
                        .setUser(userMapper.toGrpc(user))
                        .build())
                .build();
    }
}

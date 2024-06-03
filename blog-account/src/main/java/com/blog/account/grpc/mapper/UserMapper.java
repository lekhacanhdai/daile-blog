package com.blog.account.grpc.mapper;

import com.blog.account.domain.entity.UserEntity;
import com.blog.proto.mapper.GrpcMapper;
import com.daile.blog.account.User;
import org.springframework.stereotype.Component;

/**
 * @author daile
 * @since 01/06/2024
 */

@Component
public class UserMapper extends GrpcMapper<UserEntity, User, User.Builder> {

    @Override
    public User toGrpc(UserEntity input) {
        return User.newBuilder()
                .setEmail(input.getEmail())
                .setUserId(input.getUserId().toString())
                .setFullName(input.getFullName())
                .setUsername(input.getUsername())
                .build();
    }

    @Override
    public User.Builder toGrpcBuilder(UserEntity input) {
        return null;
    }

}

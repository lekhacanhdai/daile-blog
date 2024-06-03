package com.blog.gateway.grpc.stub;

import com.daile.blog.account.UserGrpcServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author daile
 * @since 02/06/2024
 */

@Configuration
public class AccountGrpcStub {

    @Bean
    public UserGrpcServiceGrpc.UserGrpcServiceBlockingStub userGrpcServiceBlockingStub(@Qualifier("AccountGrpcChannel") ManagedChannel channel) {
        return UserGrpcServiceGrpc.newBlockingStub(channel);
    }
}

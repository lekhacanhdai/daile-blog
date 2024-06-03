package com.blog.gateway.grpc.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author daile
 * @since 02/06/2024
 */

@Configuration
@RequiredArgsConstructor
public class ChannelConfig {
    private final Environment environment;

    @Bean("AccountGrpcChannel")
    public ManagedChannel accountGrpcChannel() {
        return ManagedChannelBuilder.forAddress(
                environment.getRequiredProperty("grpc.account.host", String.class),
                environment.getRequiredProperty("grpc.account.port", Integer.class)
        ).usePlaintext().build();
    }
}

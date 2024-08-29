package com.blog.gateway.grpc.stub;

import com.daile.blog.file.FileServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author daile
 * @since 28/08/2024
 */
@Configuration
public class FileGrpcStub {
    @Bean
    public FileServiceGrpc.FileServiceBlockingStub fileServiceBlockingStub(@Qualifier("FileGrpcChannel")ManagedChannel channel) {
        return FileServiceGrpc.newBlockingStub(channel);
    }
}

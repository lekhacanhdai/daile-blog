package com.blog.gateway.grpc.stub;

import com.daile.blog.post.PostGrpcServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author daile
 * @since 10/06/2024
 */
@Configuration
public class PostGrpcStub {
  @Bean
  public PostGrpcServiceGrpc.PostGrpcServiceBlockingStub postGrpcServiceBlockingStub(
      @Qualifier("postGrpcChannel") ManagedChannel channel) {
    return PostGrpcServiceGrpc.newBlockingStub(channel);
  }
}

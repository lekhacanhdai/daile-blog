package com.blog.proto.utils;

import com.daile.blog.common.Code;
import com.daile.blog.common.GrpcError;
import io.grpc.stub.StreamObserver;
import java.util.function.Function;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author daile
 * @since 26/05/2024
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GrpcServerUtils {
  public static <R, S> void execute(
      R request,
      StreamObserver<S> streamObserver,
      Function<R, S> handler,
      Function<Exception, S> exceptionHandler) {
    try {
      streamObserver.onNext(handler.apply(request));
      streamObserver.onCompleted();
    } catch (Exception e) {
      exceptionHandler.apply(e);
      streamObserver.onCompleted();
      throw e;
    }
  }

  public static GrpcError getError(Exception e) {
    return GrpcError.newBuilder().setCode(Code.CODE_UNKNOWN).setMessage(e.getMessage()).build();
  }
}

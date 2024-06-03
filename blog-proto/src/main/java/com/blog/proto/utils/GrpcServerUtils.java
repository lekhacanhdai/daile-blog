package com.blog.proto.utils;

import com.daile.blog.common.Code;
import com.daile.blog.common.GrpcError;
import io.grpc.stub.StreamObserver;

import java.util.function.Function;

/**
 * @author daile
 * @since 26/05/2024
 */

public class GrpcServerUtils {
    public static <Req, Res> void execute(
            Req request,
            StreamObserver<Res> streamObserver,
            Function<Req, Res> handler,
            Function<Exception, Res> exceptionHandler
    ) {
        try {
            streamObserver.onNext(handler.apply(request));
            streamObserver.onCompleted();
        } catch (Exception e) {
            exceptionHandler.apply(e);
            streamObserver.onCompleted();
            throw e;
        }
    }

    public static GrpcError getError(Exception e){
        return GrpcError.newBuilder()
                .setCode(Code.CODE_UNKNOWN)
                .setMessage(e.getMessage())
                .build();
    }
}

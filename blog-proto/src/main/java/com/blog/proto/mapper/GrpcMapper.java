package com.blog.proto.mapper;

import com.google.protobuf.GeneratedMessageV3;
import java.util.List;

/**
 * @author daile
 * @since 01/06/2024
 */
public abstract class GrpcMapper<
    I, A extends GeneratedMessageV3, O extends GeneratedMessageV3.Builder<O>> {

  public abstract A toGrpc(I input);

  public abstract O toGrpcBuilder(I input);

  public List<A> toGrpc(List<I> inputs) {
    return inputs.stream().map(this::toGrpc).toList();
  }
}

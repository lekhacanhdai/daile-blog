package com.blog.proto.exception;

/**
 * @author daile
 * @since 02/06/2024
 */
public class GrpcNotFoundException extends RuntimeException {
  public GrpcNotFoundException(String message) {
    super(message);
  }
}

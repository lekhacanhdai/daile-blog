package com.blog.proto.exception;

/**
 * @author daile
 * @since 02/06/2024
 */
public class GrpcNotFoundException extends RuntimeException {
  //    private static final long serialVersionUID = 603124386976562965L;

  public GrpcNotFoundException(String message) {
    super(message);
  }
}

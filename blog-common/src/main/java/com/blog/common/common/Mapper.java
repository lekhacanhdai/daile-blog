package com.blog.common.common;

/**
 * @author daile
 * @since 01/06/2024
 */
public abstract class Mapper<I, O> {
  public abstract O convert(I input);
}

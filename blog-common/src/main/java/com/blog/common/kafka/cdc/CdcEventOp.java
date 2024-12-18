package com.blog.common.kafka.cdc;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author daile
 * @since 08/06/2024
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CdcEventOp {
  public static final String UPDATE = "u";
  public static final String CREATE = "c";
  public static final String READ = "r";
  public static final String DELETE = "d";
}

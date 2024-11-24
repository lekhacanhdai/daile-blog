package com.blog.common.kafka.cdc;

import lombok.Getter;
import lombok.Setter;

/**
 * @author daile
 * @since 08/06/2024
 */
@Getter
@Setter
public abstract class BCdcObject<E> {
  protected abstract E toEntity();
}

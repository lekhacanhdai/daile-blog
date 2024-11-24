package com.blog.common.kafka.cdc;

import java.io.Serializable;
import java.util.Map;
import lombok.*;

/**
 * @author daile
 * @since 08/06/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CdcPayload implements Serializable {
  private Map<String, Object> after;
  private Map<String, Object> before;
  private String op;
}

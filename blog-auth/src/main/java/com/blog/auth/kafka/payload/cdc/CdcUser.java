package com.blog.auth.kafka.payload.cdc;

import com.blog.auth.domain.entity.CdcUserEntity;
import com.blog.common.kafka.cdc.BCdcObject;
import java.util.UUID;
import lombok.*;
import org.springframework.beans.BeanUtils;

/**
 * @author daile
 * @since 08/06/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CdcUser extends BCdcObject<CdcUserEntity> {
  private UUID userId;
  private String username;
  private String password;
  private String email;
  private Integer status;
  private String fullName;

  @Override
  protected CdcUserEntity toEntity() {
    var entity = new CdcUserEntity();
    BeanUtils.copyProperties(this, entity);
    return entity;
  }
}

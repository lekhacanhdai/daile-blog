package com.blog.auth.kafka.payload.cdc;

import com.blog.auth.domain.entity.CdcRoleEntity;
import com.blog.common.kafka.cdc.BCdcObject;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * @author daile
 * @since 10/06/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CdcRole extends BCdcObject<CdcRoleEntity> {
  private UUID roleId;
  private String role;
  private String description;
  private Integer status;

  @Override
  protected CdcRoleEntity toEntity() {
    var entity = new CdcRoleEntity();
    BeanUtils.copyProperties(this, entity);
    return entity;
  }
}

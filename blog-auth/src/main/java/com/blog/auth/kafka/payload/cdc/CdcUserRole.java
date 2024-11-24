package com.blog.auth.kafka.payload.cdc;

import com.blog.auth.domain.entity.CdcRoleEntity;
import com.blog.auth.domain.entity.CdcUserEntity;
import com.blog.auth.domain.entity.CdcUserRoleEntity;
import com.blog.common.kafka.cdc.BCdcObject;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author daile
 * @since 10/06/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CdcUserRole extends BCdcObject<CdcUserRoleEntity> {
  private UUID userRoleId;
  private UUID userId;
  private UUID roleId;

  @Override
  protected CdcUserRoleEntity toEntity() {
    CdcUserRoleEntity entity = new CdcUserRoleEntity();
    CdcUserEntity user = new CdcUserEntity();
    user.setUserId(userId);
    CdcRoleEntity role = new CdcRoleEntity();
    role.setRoleId(roleId);
    entity.setUserRoleId(userRoleId);
    entity.setRole(role);
    entity.setUser(user);
    return entity;
  }
}

package com.blog.auth.domain.repository;

import com.blog.auth.domain.entity.CdcRoleEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author dai.le-anh
 * @since 3/18/2024
 */
@Repository
public interface RoleRepository extends JpaRepository<CdcRoleEntity, UUID> {
  @Query(
      "SELECT r FROM CdcRoleEntity r "
          + "WHERE EXISTS (SELECT 1 FROM CdcUserRoleEntity ur WHERE ur.role.roleId = r.roleId AND ur.user.userId = :userId)")
  List<CdcRoleEntity> findAllByUserId(@Param("userId") UUID userId);
}

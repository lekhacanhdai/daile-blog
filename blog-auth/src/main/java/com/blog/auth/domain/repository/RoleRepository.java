package com.blog.auth.domain.repository;

import com.blog.auth.domain.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author dai.le-anh
 * @since 3/18/2024
 */

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
    @Query("SELECT r FROM RoleEntity r " +
            "WHERE EXISTS (SELECT 1 FROM UserRoleEntity ur WHERE ur.role.roleId = r.roleId AND ur.user.userId = :userId)")
    List<RoleEntity> findAllByUserId(@Param("userId") UUID userId);
}

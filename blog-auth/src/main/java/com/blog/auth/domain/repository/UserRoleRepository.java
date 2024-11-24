package com.blog.auth.domain.repository;

import com.blog.auth.domain.entity.CdcUserRoleEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dai.le-anh
 * @since 3/18/2024
 */
@Repository
public interface UserRoleRepository extends JpaRepository<CdcUserRoleEntity, UUID> {}

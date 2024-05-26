package com.blog.account.domain.repository;

import com.blog.account.domain.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author daile
 * @since 26/05/2024
 */

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, UUID> {
}

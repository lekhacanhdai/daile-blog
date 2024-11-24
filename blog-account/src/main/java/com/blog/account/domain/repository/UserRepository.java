package com.blog.account.domain.repository;

import com.blog.account.domain.entity.UserEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author daile
 * @since 26/05/2024
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {}

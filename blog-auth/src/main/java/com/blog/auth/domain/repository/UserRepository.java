package com.blog.auth.domain.repository;

import com.blog.auth.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author dai.le-anh
 * @since 3/18/2024
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    @Query("SELECT u FROM UserEntity u " +
            "LEFT JOIN FETCH u.roles " +
            "WHERE u.username = :username")
    Optional<UserEntity> findByUsername(String username);
}

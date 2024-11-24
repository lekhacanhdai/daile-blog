package com.blog.auth.domain.repository;

import com.blog.auth.domain.entity.CdcUserEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author dai.le-anh
 * @since 3/18/2024
 */
@Repository
public interface UserRepository extends JpaRepository<CdcUserEntity, UUID> {
  @Query(
      "SELECT u FROM CdcUserEntity u "
          + "LEFT JOIN FETCH u.roles "
          + "WHERE u.username = :username")
  Optional<CdcUserEntity> findByUsername(String username);
}

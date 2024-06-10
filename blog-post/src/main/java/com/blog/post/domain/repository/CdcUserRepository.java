package com.blog.post.domain.repository;

import com.blog.post.domain.entity.CdcUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author daile
 * @since 10/06/2024
 */

@Repository
public interface CdcUserRepository extends JpaRepository<CdcUserEntity, UUID> {
}

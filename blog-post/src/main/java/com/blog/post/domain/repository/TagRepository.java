package com.blog.post.domain.repository;

import com.blog.post.domain.entity.TagEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author daile
 * @since 10/06/2024
 */
@Repository
public interface TagRepository extends JpaRepository<TagEntity, UUID> {}

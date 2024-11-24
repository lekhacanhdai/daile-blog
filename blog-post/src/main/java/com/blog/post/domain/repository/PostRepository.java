package com.blog.post.domain.repository;

import com.blog.post.domain.entity.PostEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author daile
 * @since 10/06/2024
 */
@Repository
public interface PostRepository extends JpaRepository<PostEntity, UUID> {}

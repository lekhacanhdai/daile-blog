package com.blog.post.domain.repository;

import com.blog.post.domain.entity.PostTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author daile
 * @since 10/06/2024
 */

@Repository
public interface PostTagRepository extends JpaRepository<PostTagEntity, UUID> {
    @Query("SELECT pt FROM PostTagEntity pt " +
            "WHERE pt.post.postId = :postId")
    List<PostTagEntity> findAllByPostId(@Param("postId") UUID postId);
}

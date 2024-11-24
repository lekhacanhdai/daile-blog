package com.blog.post.domain.repository.dsl;

import com.blog.common.domain.Page;
import com.blog.post.domain.entity.PostEntity;
import com.blog.post.domain.entity.QPostEntity;
import com.blog.post.domain.entity.QPostTagEntity;
import com.blog.proto.utils.PageableUtils;
import com.daile.blog.post.MListPostRequest;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * @author daile
 * @since 12/06/2024
 */
@Repository
@RequiredArgsConstructor
public class PostDslRepository {
  private final JPAQueryFactory queryFactory;
  private static final QPostEntity post = QPostEntity.postEntity;
  private static final QPostTagEntity postTag = QPostTagEntity.postTagEntity;

  public Page<PostEntity> listPost(MListPostRequest request) {
    var page = PageableUtils.getPage(request.getPageable().getPage());
    var size = PageableUtils.getSize(request.getPageable().getSize());
    var order = PageableUtils.getOrder(request.getPageable().getDirection());

    var query = queryFactory.select(post).from(post);
    if (StringUtils.isNoneBlank(request.getSearchTerm())) {
      query.where(
          post.title
              .containsIgnoreCase(request.getSearchTerm())
              .or(post.content.containsIgnoreCase(request.getSearchTerm())));
    }

    if (StringUtils.isNoneBlank(request.getUserId())) {
      query.where(post.userId.eq(request.getUserId().transform(UUID::fromString)));
    }

    if (!request.getTagIdsList().isEmpty()) {
      query.where(
          queryFactory
              .selectZero()
              .from(postTag)
              .where(
                  postTag
                      .post
                      .postId
                      .eq(post.postId)
                      .and(
                          postTag.tag.tagId.in(
                              request.getTagIdsList().stream().map(UUID::fromString).toList())))
              .exists());
    }

    var countQuery = query.clone().select(post.postId.count());
    if (request.getPageable().getSort().equalsIgnoreCase("title")) {
      query.orderBy(
          new OrderSpecifier<>(order, post.title, OrderSpecifier.NullHandling.NullsFirst));
    } else {
      query.orderBy(
          new OrderSpecifier<>(order, post.postId, OrderSpecifier.NullHandling.NullsFirst));
    }

    if (!request.getPageable().getIgnorePage()) {
      query.limit(size).offset(page * size);
    }
    return new Page<>(query.fetch(), countQuery.fetchFirst());
  }
}

package com.blog.account.domain.repository.dsl;

import com.blog.account.domain.entity.QUserEntity;
import com.blog.account.domain.entity.UserEntity;
import com.blog.common.domain.Page;
import com.blog.proto.utils.PageableUtils;
import com.daile.blog.account.ListUserRequest;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * @author daile
 * @since 01/06/2024
 */

@Repository
@RequiredArgsConstructor
public class UserDslRepository {
    private final JPAQueryFactory queryFactory;
    private final QUserEntity user = QUserEntity.userEntity;

    public Page<UserEntity> listUser(ListUserRequest request) {
        var page = PageableUtils.getPage(request.getPageable().getPage());
        var size = PageableUtils.getSize(request.getPageable().getSize());
        var order = PageableUtils.getOrder(request.getPageable().getDirection());

        var query = queryFactory.select(user).from(user);

        if (StringUtils.isNoneBlank(request.getSearchTerm())) {
            query.where(user.fullName.contains(request.getSearchTerm()));
        }

        var countQuery = query.clone().select(user.userId.count());

        if (request.getPageable().getSort().equalsIgnoreCase("username")) {
            query.orderBy(new OrderSpecifier<>(order, user.username, OrderSpecifier.NullHandling.NullsFirst));
        } else if (request.getPageable().getSort().equalsIgnoreCase("fullName")) {
            query.orderBy(new OrderSpecifier<>(order, user.fullName, OrderSpecifier.NullHandling.NullsFirst));
        } else if (request.getPageable().getSort().equalsIgnoreCase("email")) {
            query.orderBy(new OrderSpecifier<>(order, user.email, OrderSpecifier.NullHandling.NullsFirst));
        } else {
            query.orderBy(new OrderSpecifier<>(order, user.createdDate, OrderSpecifier.NullHandling.NullsFirst));
        }

        if (!request.getPageable().getIgnorePage()) {
            query.limit(size).offset(page * size);
        }

        return new Page<>(query.fetch(), countQuery.fetchFirst());
    }
}

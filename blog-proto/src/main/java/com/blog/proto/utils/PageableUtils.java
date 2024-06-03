package com.blog.proto.utils;

import com.daile.blog.common.PageableRequest;
import com.daile.blog.common.PageableResponse;
import com.querydsl.core.types.Order;

/**
 * @author daile
 * @since 02/06/2024
 */

public class PageableUtils {
    public static long getSize(Long size) {
        return (size != null) && (size > 0) ? size : 100;
    }

    public static long getPage(Long page) {
        return (page != null) && (page > 0) ? page - 1 : 0;
    }

    public static Order getOrder(String order) {
        return Order.DESC.name().equalsIgnoreCase(order) ? Order.DESC : Order.ASC;
    }

    public static PageableResponse normalize(PageableRequest request, Long totalElement) {
        return PageableResponse.newBuilder()
                .setPage(getPage(request.getPage()))
                .setSize(getSize(request.getSize()))
                .setTotalElements(totalElement)
                .setTotalPages((totalElement / getSize(request.getSize()) + 1))
                .build();
    }
}
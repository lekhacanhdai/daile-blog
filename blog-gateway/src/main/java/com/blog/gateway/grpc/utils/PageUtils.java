package com.blog.gateway.grpc.utils;

import com.daile.blog.common.PageableRequest;
import org.apache.commons.lang3.StringUtils;

/**
 * @author daile
 * @since 02/06/2024
 */
public class PageUtils {
  public static PageableRequest toGrpcPageable(
      com.blog.gateway.payload.request.PageableRequest request) {
    return PageableRequest.newBuilder()
        .setPage(request.getPage() != null ? request.getPage() : 1)
        .setSize(request.getSize() != null ? request.getSize() : 100)
        .setDirection(StringUtils.defaultString(request.getDirection()))
        .setSort(StringUtils.defaultString(request.getSort()))
        .setIgnorePage(Boolean.TRUE.equals(request.getIgnorePage()))
        .build();
  }
}

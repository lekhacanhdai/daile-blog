package com.blog.gateway.payload.response.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author daile
 * @since 28/08/2024
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileResponse {
  private String path;
}

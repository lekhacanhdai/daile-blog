package com.blog.gateway.payload.request.post;

import com.blog.gateway.payload.request.PageableRequest;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author daile
 * @since 10/06/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListPostRequest extends PageableRequest {
  private String searchTerm;
  private String userId;
  private List<String> tagIds;
}

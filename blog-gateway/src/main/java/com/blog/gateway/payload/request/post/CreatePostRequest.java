package com.blog.gateway.payload.request.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author daile
 * @since 10/06/2024
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {
    private String title;
    private String content;
    private String status;
    private List<String> tagIds;
}

package com.blog.gateway.payload.response.post;

import lombok.*;

import java.util.List;

/**
 * @author daile
 * @since 10/06/2024
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "set", builderMethodName = "newBuilder")
public class PostDTO {
    private String postId;
    private String title;
    private String content;
    private String userId;
    private String fullName;
    private String status;
    private String publishedDate;
    private List<TagDTO> tags;
}

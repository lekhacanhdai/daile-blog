package com.blog.gateway.payload.response.post;

import lombok.*;

/**
 * @author daile
 * @since 10/06/2024
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "set", builderMethodName = "newBuilder")
public class TagDTO {
    private String tagId;
    private String tagName;
    private String description;
}

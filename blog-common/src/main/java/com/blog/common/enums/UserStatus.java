package com.blog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author daile
 * @since 26/05/2024
 */

@AllArgsConstructor
@Getter
public enum UserStatus {
    ACTIVE(1, "ACTIVE"),
    INACTIVE(2, "INACTIVE"),
    DELETED(3, "DELETED");

    private final Integer id;
    private final String name;

    public static boolean isValid(String status) {
        return Arrays.stream(values()).anyMatch(s -> s.getName().equals(status));
    }

    public static UserStatus parse(String status) {
        return Arrays.stream(values()).filter(s -> s.getName().equals(status)).findFirst().orElse(INACTIVE);
    }
}

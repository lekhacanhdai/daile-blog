package com.blog.account.validator;

import com.daile.blog.account.UserRegistrationRequest;
import com.daile.blog.account.UserRegistrationResponse;

/**
 * @author daile
 * @since 26/05/2024
 */
public interface UserValidator {
    boolean validateUserRegistration(UserRegistrationRequest request, UserRegistrationResponse.Builder builder);
}

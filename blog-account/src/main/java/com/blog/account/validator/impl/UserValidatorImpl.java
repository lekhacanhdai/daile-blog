package com.blog.account.validator.impl;

import com.blog.account.validator.UserValidator;
import com.daile.blog.account.UserRegistrationRequest;
import com.daile.blog.common.IdResponse;
import org.springframework.stereotype.Component;

/**
 * @author daile
 * @since 26/05/2024
 */

@Component
public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validateUserRegistration(UserRegistrationRequest request, IdResponse.Builder builder) {
        // TODO
        return true;
    }
}

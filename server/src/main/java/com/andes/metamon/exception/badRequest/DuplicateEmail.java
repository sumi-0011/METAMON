package com.andes.metamon.exception.badRequest;

import com.andes.metamon.exception.BaseResponseStatusCode;
import com.andes.metamon.exception.CustomExcetion;

import static com.andes.metamon.exception.BaseResponseStatusCode.USER_EMAIL_DUPLICATE;

public class DuplicateEmail extends CustomExcetion {
    public DuplicateEmail() {
        super(USER_EMAIL_DUPLICATE.getMessage(), USER_EMAIL_DUPLICATE);
    }
}

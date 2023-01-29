package com.andes.metamon.exception.badRequest;

import com.andes.metamon.exception.BaseResponseStatusCode;
import com.andes.metamon.exception.CustomExcetion;

import static com.andes.metamon.exception.BaseResponseStatusCode.USER_PASSWORD_NOT_MATCH;

public class NotMatchPassword extends CustomExcetion {
    public NotMatchPassword() {
        super(USER_PASSWORD_NOT_MATCH.getMessage(), USER_PASSWORD_NOT_MATCH);
    }
}

package com.andes.metamon.exception.invalidToken;

import com.andes.metamon.exception.BaseResponseStatusCode;
import com.andes.metamon.exception.CustomExcetion;

import static com.andes.metamon.exception.BaseResponseStatusCode.TOKEN_NOT_REQUIRED;

public class NotRequiredToken extends CustomExcetion {
    public NotRequiredToken() {
        super(TOKEN_NOT_REQUIRED.getMessage(), TOKEN_NOT_REQUIRED);
    }
}

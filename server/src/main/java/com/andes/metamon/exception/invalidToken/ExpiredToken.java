package com.andes.metamon.exception.invalidToken;

import com.andes.metamon.exception.BaseResponseStatusCode;
import com.andes.metamon.exception.CustomExcetion;

import static com.andes.metamon.exception.BaseResponseStatusCode.TOKEN_EXPIRED;

public class ExpiredToken extends CustomExcetion {
    public ExpiredToken() {
        super(TOKEN_EXPIRED.getMessage(), TOKEN_EXPIRED);
    }
}

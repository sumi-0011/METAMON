package com.andes.metamon.exception.badRequest;

import com.andes.metamon.exception.BaseResponseStatusCode;
import com.andes.metamon.exception.CustomExcetion;

import static com.andes.metamon.exception.BaseResponseStatusCode.TOKEN_HEADER_EMPTY;

public class NotFoundTokenFromHeader extends CustomExcetion {
    public NotFoundTokenFromHeader() {
        super(TOKEN_HEADER_EMPTY.getMessage(), TOKEN_HEADER_EMPTY);
    }
}

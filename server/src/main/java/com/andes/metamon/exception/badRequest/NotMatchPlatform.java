package com.andes.metamon.exception.badRequest;

import com.andes.metamon.exception.BaseResponseStatusCode;
import com.andes.metamon.exception.CustomExcetion;

import static com.andes.metamon.exception.BaseResponseStatusCode.NOT_MATCH_PLATFORM;

public class NotMatchPlatform extends CustomExcetion {
    public NotMatchPlatform() {
        super(NOT_MATCH_PLATFORM.getMessage(), NOT_MATCH_PLATFORM);
    }
}

package com.andes.metamon.exception.badRequest;

import com.andes.metamon.exception.BaseResponseStatusCode;
import com.andes.metamon.exception.CustomExcetion;

import static com.andes.metamon.exception.BaseResponseStatusCode.IDCARD_DUPLICATE_PLATFORM;

public class DuplicateIdCardPlatform extends CustomExcetion {
    public DuplicateIdCardPlatform() {
        super(IDCARD_DUPLICATE_PLATFORM.getMessage(), IDCARD_DUPLICATE_PLATFORM);
    }
}

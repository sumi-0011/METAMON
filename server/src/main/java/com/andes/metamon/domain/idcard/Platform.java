package com.andes.metamon.domain.idcard;

import com.andes.metamon.exception.badRequest.DuplicateIdCardPlatform;
import com.andes.metamon.exception.badRequest.NotMatchPlatform;

public enum Platform {
    ZEPETO,
    USER,
    ROBLOX;

    public static Platform match(String platform) {
        if (platform.equals("ZEPETO")) {
            return Platform.ZEPETO;
        }
        if (platform.equals("ROBLOX")) {
            return Platform.ROBLOX;
        }
        throw new NotMatchPlatform();
    }
}

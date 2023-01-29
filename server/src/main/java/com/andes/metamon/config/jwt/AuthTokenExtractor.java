package com.andes.metamon.config.jwt;

import com.andes.metamon.exception.invalidToken.InvalidTokenForm;
import com.andes.metamon.exception.badRequest.NotFoundTokenFromHeader;
import org.springframework.stereotype.Component;

@Component
public class AuthTokenExtractor {
    public String extractToken(final String authorizationHeader, final String tokenType) {
        if (authorizationHeader == null) {
            throw new NotFoundTokenFromHeader();
        }
        final String[] splitHeaders = authorizationHeader.split(" ");
        if (splitHeaders.length != 2 || !splitHeaders[0].equalsIgnoreCase(tokenType)) {
            throw new InvalidTokenForm();
        }
        return splitHeaders[1];
    }
}

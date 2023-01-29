package com.andes.metamon.config.jwt;

import com.andes.metamon.exception.invalidToken.InvalidTokenForm;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {
    private static final String TOKEN_TYPE = "Bearer";
    private static final String ACCESS_TOKEN_SUBJECT = "AccessToken";

    private final AuthTokenExtractor authTokenExtractor;
    private final Key secretKey;
    private final long validityInMilliseconds;

    public JwtProvider(AuthTokenExtractor authTokenExtractor,
                       @Value("${jwt.secret}") final String secretKey,
                       @Value("${jwt.expire-length}") final long validityInMilliseconds) {
        this.authTokenExtractor = authTokenExtractor;
        this.secretKey = Keys.hmacShaKeyFor((secretKey.getBytes(StandardCharsets.UTF_8)));
        this.validityInMilliseconds = validityInMilliseconds;
    }

    public String createAccessToken(final Long id) {
        final Date now = new Date();
        final Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(ACCESS_TOKEN_SUBJECT)
                .setIssuedAt(now)
                .setExpiration(validity)
                .claim("id", id)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isValidToken(final String authorizationHeader) {
        final String token = authTokenExtractor.extractToken(authorizationHeader, TOKEN_TYPE);
        try {
            final Jws<Claims> claims = getClaimsJws(token);
            return isAccessToken(claims) && isNotExpired(claims);
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    private boolean isNotExpired(Jws<Claims> claims) {
        return claims.getBody().getExpiration().after(new Date());
    }

    private boolean isAccessToken(Jws<Claims> claims) {
        return claims.getBody().getSubject().equals(ACCESS_TOKEN_SUBJECT);
    }

    private Jws<Claims> getClaimsJws(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);
    }

    public MemberPayload getPayload(String authorizationHeader) {
        final String token = authTokenExtractor.extractToken(authorizationHeader, TOKEN_TYPE);
        Claims body = getClaimsJws(token).getBody();
        try {
            return new MemberPayload(body.get("id", Long.class));
        } catch (RequiredTypeException | NullPointerException | IllegalArgumentException exception) {
            throw new InvalidTokenForm();
        }
    }
}

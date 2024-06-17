package com.example.travel_itinerary_backend2.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.travel_itinerary_backend2.config.AppProperties;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class TokenProvider {

    private final AppProperties appProperties;
    private final Algorithm ALGORITHM;
    @Autowired
    public TokenProvider(AppProperties appProperties) {
        this.appProperties = appProperties;
        this.ALGORITHM = Algorithm.HMAC256(appProperties.getAuth().getTokenSecret());
    }

    public String createToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + appProperties.getAuth().getTokenExpirationMsec());

        return JWT.create()
                .withSubject(Long.toString(userPrincipal.getId()))
                .withIssuedAt(now)
                .withExpiresAt(expirationDate)
                .sign(ALGORITHM);
    }

    public Long getUserIdFromToken(String token) {
        JWTVerifier verifier = JWT.require(ALGORITHM).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String subject = decodedJWT.getSubject();
        return Long.parseLong(subject);
    }

    public boolean validateToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(ALGORITHM).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            log.error("Invalid or expired JWT.");
        }
        return false;
    }
}

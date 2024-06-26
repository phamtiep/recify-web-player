package com.swe.recify.security;

import com.swe.recify.reponse.UserDTO;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;


@Component("tokenProvider")
@Slf4j
public class JwtTokenProvider {

    private final String JWT_SECRET = "05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas05252zas";


    private final long JWT_EXPIRATION = 604800000L;

    // Tạo ra jwt từ thông tin user

    public String generateToken(UserDTO userDTO) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(userDTO.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

   
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .build().parseSignedClaims(token).getPayload();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).build().parseSignedClaims(authToken).getPayload();;
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}

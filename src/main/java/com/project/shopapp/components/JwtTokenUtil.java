package com.project.shopapp.components;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.project.shopapp.models.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtTokenUtil {

    @Value("${jwt.expiration}")
    private int expiration;

    @Value("${jwt.secretKey}")
    private String secretKey;

    @SuppressWarnings("deprecation")
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        try {
            String token = Jwts.builder()
                    .setClaims(claims)
                    .setSubject(user.getPhoneNumber())
                    .setExpiration(new Date(System.currentTimeMillis() + this.expiration * 1000L))
                    .signWith(getSignKey(), SignatureAlgorithm.ES256)
                    .compact();
            return token;
        } catch (Exception e) {
            System.out.println("jwt create error");
            return null;
        }
    }

    private Key getSignKey() {
        byte[] bytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(bytes);
    }

//     public Claims extractAllClaims(String token) {
//         return Jwts.par
//     }
}

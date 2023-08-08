package com.api.innovation.infra.utils.token;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.api.innovation.infra.config.security.token.AuthToken;
import com.api.innovation.infra.databases.hibernate.users.models.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenUtil {

    // Como esse é um sistema de teste somente, vou manter essas informações nesse arquivo mesmo,
    // mas a prática correta seria adicionar em um arquivo de configuração e adicionar esse arquivo no .gitignore;
    private static final String API_TOKEN_ISSUER = "INNOVATION_TEST";
    private static final String API_TOKEN_HEADER = "Bearer ";
    private static final String API_TOKEN_SECRET_KEY = "$2a$12$IdbbBzaOOV2PpPzHXGRLIOMnBpEnGPzbtkBZhcOEhBRT/rwGC68de";
    private static final long  API_TOKEN_EXPIRATION_TIME = (1000 * 60) * 60;

    public static AuthToken encodeToken(User user) {
        Key secretKey = Keys.hmacShaKeyFor(API_TOKEN_SECRET_KEY.getBytes());

        String tokenJwt = Jwts.builder()
            .setSubject(user.getEmail())
            .setIssuer(API_TOKEN_ISSUER)
            .setExpiration(new Date(System.currentTimeMillis() + API_TOKEN_EXPIRATION_TIME))
            .signWith(secretKey, SignatureAlgorithm.HS256)
            .compact();

        AuthToken token = new AuthToken(
            API_TOKEN_HEADER + tokenJwt, 
            API_TOKEN_EXPIRATION_TIME
        );

        return token;
    }
    
    public static Authentication decodeToken(HttpServletRequest request) {
        try {
            String bearerToken = request.getHeader("Authorization");
            String token = bearerToken.replace(API_TOKEN_HEADER, "");

            Jws<Claims> jwsClaims = Jwts.parserBuilder()
                            .setSigningKey(API_TOKEN_SECRET_KEY.getBytes())
                            .build()
                            .parseClaimsJws(token);

            String emailDecodedToken = jwsClaims.getBody().getSubject();
            String issuerDecodedToken = jwsClaims.getBody().getIssuer();

            if (emailDecodedToken.length() > 0 && issuerDecodedToken.equals(API_TOKEN_ISSUER)) {
                return new UsernamePasswordAuthenticationToken(
                    emailDecodedToken, null, 
                    Collections.emptyList()
                );
            }

            return null;
        } catch (Exception exception) {
            return null;
        }
    }
}

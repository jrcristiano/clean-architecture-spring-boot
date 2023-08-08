package com.api.innovation.infra.config.security.token;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthToken {
    private String accessToken;
    private long expiresIn;

    public AuthToken(String accessToken, long expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }
}

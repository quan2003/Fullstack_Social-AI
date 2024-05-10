package com.viuniteam.socialviuni.security.jwt;

import java.io.Serializable;

import lombok.Data;


public class JwtResponse implements Serializable {
    private final String jwtToken;

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}

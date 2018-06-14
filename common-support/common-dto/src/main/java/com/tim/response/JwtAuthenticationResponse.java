package com.tim.response;

import java.io.Serializable;

/**
 * @description:
 * @author: lizhiming
 * @date: 2018/6/1 19:38
 */
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}

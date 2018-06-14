package com.tim.service.auth;

import com.tim.request.JwtAuthenticationRequest;

/**
 * @description:
 * @author: lizhiming
 * @create: 2018/4/20 15:30
 */
public interface IAuthService {
    String login(JwtAuthenticationRequest authenticationRequest) throws Exception;
}

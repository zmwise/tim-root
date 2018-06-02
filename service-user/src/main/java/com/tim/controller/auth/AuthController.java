package com.tim.controller.auth;

import com.tim.request.JwtAuthenticationRequest;
import com.tim.response.ObjectRestResponse;
import com.tim.service.auth.IAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: lizhiming
 * @date: 2018/6/1 19:38
 */
@RestController
@RequestMapping("jwt")
@Slf4j
public class AuthController {

    @Autowired
    private IAuthService authService;

    @RequestMapping(value = "token", method = RequestMethod.POST)
    public ObjectRestResponse<String> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {
        log.info(authenticationRequest.getUsername()+" require logging...");
        final String token = authService.login(authenticationRequest);
        return new ObjectRestResponse<>().data(token);
    }
}

package com.tim.config.jwt;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: lizhiming
 * @date: 2018/6/1 19:49
 */
@Configuration
@Data
public class KeyConfiguration {
    @Value("${jwt.rsa-secret}")
    private String userSecret;
    @Value("${client.rsa-secret}")
    private String serviceSecret;
    @Value("${client.userPubKey}")
    private byte[] userPubKey;
    @Value("${client.userPriKey}")
    private byte[] userPriKey;
    private byte[] servicePriKey;
    private byte[] servicePubKey;
}

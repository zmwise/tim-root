package com.tim.config.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import redis.clients.jedis.JedisPool;

@Configuration
public class RedisConfig {

    @Autowired
    Environment env;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.password}")
    private String password;

    @Bean
    @RefreshScope
    public JedisPool jedisPool(){
        JedisPool jedisPool = new JedisPool(new GenericObjectPoolConfig(),host,port,6000,password);
        return jedisPool;
    }
}

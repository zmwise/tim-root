package com.tim.controller.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@RestController()
@RefreshScope
public class HelloController {

    @Value("${tim.configVal}")
    private String configVal;
    @Value("${tim.defConfigVal}")
    private String defConfigVal;
    @Value("${config-from}")
    private String configFrom;

    @Autowired
    private JedisPool jedisPool;

    @GetMapping("/index")
    public String index(){
        return "Hello World";
    }

    @GetMapping("/send")
    public String send(){
        String value = jedisPool.getResource().get("hello");
        return "configFrom="+configFrom+"------configVal=" + configVal + "------redisHelloVal="+value + "------defConfigVal="+defConfigVal;
    }


}

package com.tim.config.fegin;

import feign.Logger;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @description:
 * @author: lizhiming
 * @date: 2018/6/8 11:01
 */
@Configuration
public class FeignMultipartSupportConfig {
    @Bean
    @Primary
    @Scope("prototype")
    public Encoder feignFormEncoder(){
        return new SpringFormEncoder();
    }
    /*@Bean
    public Logger.Level multipartLoggerLevel() {
        return Logger.Level.FULL;
    }*/
}

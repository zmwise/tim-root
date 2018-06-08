package com.tim.config.fegin;

import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.FormHttpMessageConverter;

@Configuration
public class FeignSimpleEncoderConfig {

    public static final int FIVE_SECONDS = 5000;

    @Bean
    public Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(FIVE_SECONDS, FIVE_SECONDS);
    }

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder()
                .encoder(new FormEncoder());
    }

    @Bean
    public Encoder encoder(){
        ObjectFactory<HttpMessageConverters> objectFactory = () ->
                new HttpMessageConverters(new FormHttpMessageConverter());
        return new SpringEncoder(objectFactory);
        //return new FormEncoder();
    }
}

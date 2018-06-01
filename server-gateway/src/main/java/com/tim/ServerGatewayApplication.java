package com.tim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ServerGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerGatewayApplication.class, args);
	}
}

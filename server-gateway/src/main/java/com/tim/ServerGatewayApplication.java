package com.tim;

import com.tim.filter.PermissionsFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
@Slf4j
public class ServerGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerGatewayApplication.class, args);
		log.info("【GateWay网关服务】启动成功！！！");
	}

	@Bean
	PermissionsFilter permissionsFilter(){
		return new PermissionsFilter();
	}
}

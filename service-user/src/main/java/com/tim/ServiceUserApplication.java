package com.tim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceUserApplication {

	/**
	 * @EnableDiscoveryClient注解能激活Eureka中的DiscoveryClient实现，这样才能实现Controller中对服务信息的输出
	 */

	private static Logger logger = LoggerFactory.getLogger(ServiceUserApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServiceUserApplication.class, args);
		logger.info("【用户服务】启动成功！！！");
	}
}
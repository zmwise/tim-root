package com.tim;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description: 用户服务程序入口
 * @author: lizhiming
 * @create: 2018/4/20 15:30
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.tim.dao")
@ComponentScan(basePackages={"com.tim"}) //如basePackages={"com.tim.service"}会有异常
public class ServiceUserApplication {

	/**
	 * @EnableDiscoveryClient注解能激活Eureka中的DiscoveryClient实现，这样才能实现Controller中对服务信息的输出
	 * @EnableFeignClients注解开启扫描Spring Cloud Feign客户端的功能
	 */

	private static Logger logger = LoggerFactory.getLogger(ServiceUserApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServiceUserApplication.class, args);
		logger.info("【用户服务】启动成功！！！");
	}
}

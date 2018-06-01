package com.tim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description: 注册中心程序入口
 * @author: lizhiming
 * @create: 2018/4/20 15:30
 */
@EnableEurekaServer
@SpringBootApplication
public class ServerEurekaApplication {

	/**
	 * @EnableEurekaServer注解启动一个服务注册中心提供给其他应用进行对话
	 */

	private static Logger logger = LoggerFactory.getLogger(ServerEurekaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServerEurekaApplication.class, args);
		logger.info("【Eureka服务注册中心】启动成功！！！");
	}
}
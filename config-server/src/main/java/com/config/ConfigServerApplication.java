package com.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @description: 配置中心程序入口
 * @author: lizhiming
 * @create: 2018/4/20 15:30
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	private static Logger logger = LoggerFactory.getLogger(ConfigServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
		logger.info("【分布式配置中心】启动成功！！！");
	}
}

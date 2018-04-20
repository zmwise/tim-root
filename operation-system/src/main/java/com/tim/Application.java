package com.tim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @description: 运营系统程序入口
 * @author: lizhiming
 * @create: 2018/4/20 15:30
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

	/**
	 * @EnableFeignClients注解开启扫描Spring Cloud Feign客户端的功能
	 * @EnableDiscoveryClient能激活Eureka中的DiscoveryClient实现，才能实现Controller中对服务信息的输出
	 */

	private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("【运营系统】启动成功！！！");
	}
}

package com.lyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.lyh"})
@ComponentScan("com.lyh")
public class DeptConsumer80_Feign_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_Feign_App.class, args);
	}
	/**
	 * Feign集成了Ribbon：
	 * 利用Ribbon维护了MicroServiceCloud-Dept的服务列表信息，
	 * 并且通过轮询实现了客户端的负载均衡。
	 * 而与Ribbon不同的是，
	 * 通过feign只需要定义服务服务绑定接口且以声明式的方法，优雅而简单的实现了服务调用。
	 */
}

package com.lyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableConfigServer
public class Config_3344_StartSpringCloud_App {
	public static void main(String[] args) {
		SpringApplication.run(Config_3344_StartSpringCloud_App.class, args);
	}
}
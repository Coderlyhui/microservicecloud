package com.myRule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class MySelfRule {

	@Bean
	public IRule myRule() {
		//return new RandomRule();
		return new RandomRule_LYH();  //自定义的随机 每台机器3次
	}
}

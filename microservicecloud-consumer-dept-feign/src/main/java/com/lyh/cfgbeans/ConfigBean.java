package com.lyh.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean {
	
	/*
	单机 未加Ribbon负载均衡
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}*/
	
	@Bean
	@LoadBalanced 	//springCloud Ribbon实现的一套客户端负载均衡的工具
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * 负载均衡：默认使用轮询算法，若存在自己定义的算法则使用自己定义的算法。
	 * 以下是Ribbon的核心组件IRule中提供的几种算法：
	 * 1、RoundRobinRule  轮询
	 * 2、RandomRule  随机
	 * 3、AvailabilityFilteringRule 会先过滤掉由于多次访问故障而处于熔断器跳闸状态的服务，还有并发的连接数量超过阈值的服务，
	 * 							         然后对剩余的服务列表按照轮询策略进行访问。
	 * 4、WeightedResponseTimeRule  根据平均响应时间计算所有服务的权重，响应时间越快 服务权重越大 被选中的概率越高，
	 * 							         刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够时切换到WeightedResponseTimeRule。
	 * 5、RetryRule  先按照RoundRobinRule策略获取服务，如果获取服务失败 则在指定时间内进行重试，获取可用的服务。
	 * 6、BestAvailableRule  会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量小的服务。
	 * 7、ZoneAvoidanceRule  默认规则，复合判断server所在区域的性能和server的可用性 选择服务器。
	 */
	
	@Bean
	public IRule myRule() {
		return new RandomRule();	//达到的目的：用我们重新定义的随机算法替代默认的轮询算法。
	}
	
	/**
	 * 如若不想使用IRule中提供的几种算法，还可以定义自己的算法。
	 * 实现方式：
	 * @RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)
	 * 
	 * MySelfRule这个自定义的配置类不能放在@ComponentScan所扫描的当前包下及其子包下，
	 * 否则，我们自定义的这个配置类就会被所有的Ribbon客户端所共享，也就是说达不到了特殊化定制的目的了。
	 * 注：主启动类上的@SpringBootApplication注解包含@ComponentScan
	 */
	
	
	
	
}











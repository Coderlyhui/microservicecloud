package com.lyh.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lyh.bean.Dept;

@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
	
	@RequestMapping(value="/dept/add", method=RequestMethod.POST)
	boolean addDept(Dept dept);
	
	@RequestMapping(value="/dept/get/{id}", method=RequestMethod.GET)
	Dept findById(@PathVariable("id") Long id);
	
	@RequestMapping(value="/dept/list", method=RequestMethod.GET)
	List<Dept> findAll();
	
	/**
	 * Feign集成了Ribbon：
	 * 利用Ribbon维护了MicroServiceCloud-Dept的服务列表信息，
	 * 并且通过轮询实现了客户端的负载均衡。
	 * 而与Ribbon不同的是，
	 * 通过feign只需要定义服务服务绑定接口且以声明式的方法，优雅而简单的实现了服务调用。
	 */
	
	/**
	 * 熔断器之服务降级（利用spring的AOP）：
	 * 修改microservicecloud-api工程，根据已有的DeptClientService接口，
	 * 新建一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
	 * 在DeptClientService接口注解@FeignClient添加fallbackFactory属性
	 * microservicecloud-consumer-dept-feign修改yml，添加feign.hystrix.enabled:true
	 * 注：在类DeptClientServiceFallbackFactory上添加注解@Component注解
	 */
}












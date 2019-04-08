package com.lyh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyh.bean.Dept;
import com.lyh.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService = null;
	
	//一旦调用服务方法失败并抛出了错误信息，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	/*
	 * 但是这样对每个方法都指定对应的异常处理方法，耦合性太高，而且容易造成代码膨胀。可采用服务降级进行分离处理。
	    修改microservicecloud-api工程，根据已有的DeptClientService接口，
	 * 新建一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
	*/
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="processHystrix_Get")
	public Dept get(@PathVariable("id") Long id) {
		
		Dept dept = deptService.findById(id);
		if(null == dept) {
			throw new RuntimeException("此Id："+id+" 无对应信息！");
		}
		return dept;
	}
	
	
	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("此Id："+id+" 无对应信息，null--@HystrixCommand")
				.setDb_source("no this database in MySql");
	}	
	
}

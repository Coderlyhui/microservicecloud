package com.lyh.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lyh.bean.Dept;

import feign.hystrix.FallbackFactory;

@Component	//此注解不能丢
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {

			@Override
			public boolean addDept(Dept dept) {
				return false;
			}

			@Override
			public Dept findById(Long id) {
				return new Dept().setDeptno(id).setDname("该Id："+id+" 无对应信息，null--@HystrixCommand")
						.setDb_source("no this database in MySQL");
			}

			@Override
			public List<Dept> findAll() {
				return null;
			}
		};
	}

}

package com.lyh.service;

import java.util.List;

import com.lyh.bean.Dept;

public interface DeptService {
	boolean addDept(Dept dept);
	Dept findById(Long id);
	List<Dept> findAll();
}

package com.lyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyh.bean.Dept;
import com.lyh.dao.DeptDao;
import com.lyh.service.DeptService;

@Service
public class DeptServiceImpl implements  DeptService{

	@Autowired
	private DeptDao deptDao;
	
	@Override
	public boolean addDept(Dept dept) {
		
		return deptDao.addDept(dept);
	}

	@Override
	public Dept findById(Long id) {
		
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> findAll() {
		
		return deptDao.findAll();
	}

}

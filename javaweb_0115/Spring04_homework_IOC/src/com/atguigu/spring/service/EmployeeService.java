package com.atguigu.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.spring.dao.EmployeeDao;

@Service
public class EmployeeService {
	@Autowired
  EmployeeDao employeeDao;
	public void insertEmployee() {
		employeeDao.insertEmployee();
	}
  
}

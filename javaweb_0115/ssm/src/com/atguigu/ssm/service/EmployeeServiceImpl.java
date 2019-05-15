package com.atguigu.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.ssm.beans.Employee;
import com.atguigu.ssm.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeMapper  employeeMapper ; 
	
	@Override
	public List<Employee> getAllEmps() {
		
		return employeeMapper.getEmps();
	}
}

package com.atguigu.ssm.mapper;

import java.util.List;

import com.atguigu.ssm.beans.Employee;

/**
 * 持久层接口
 */
public interface EmployeeMapper {
	// 增删改查的方法
	public List<Employee> getEmps();

}



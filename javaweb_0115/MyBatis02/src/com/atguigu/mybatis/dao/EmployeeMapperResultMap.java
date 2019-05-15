package com.atguigu.mybatis.dao;

import java.util.List;

import com.atguigu.mybatis.beans.Employee;

public interface EmployeeMapperResultMap {

	// 查询员工并且查询部门数据
	public Employee  getEmployeeAndDept(Integer id );
	public Employee  getEmployeeAndDeptStep(Integer id );
	
	
	public List<Employee> getEmpsByDid(Integer id );
}

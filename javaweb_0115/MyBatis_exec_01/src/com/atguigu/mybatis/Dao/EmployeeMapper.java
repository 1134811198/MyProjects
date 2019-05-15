package com.atguigu.mybatis.Dao;

import com.atguigu.mybatis.beans.Employee;

public interface EmployeeMapper {
	
	public Employee getEmployeeById(Integer id);
	public void deleteEmployeeById(Integer id);
	public Long  updateEmployee(Employee employee);
	public Boolean addEmployee(Employee employee);

}

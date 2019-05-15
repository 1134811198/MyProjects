package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.beans.Employee;

/**
 * 持久层接口
 */
public interface EmployeeMapper {
	// 增删改查的方法
	
	public Employee getEmployeeById(Integer id );
	
	public Integer  addEmployee(Employee employee);
	
	public Long  updateEmployee(Employee employee);
	
	public Boolean  deleteEmployeeById(Integer id );
}


/*class EmployeeMapperImpl  implements  EmployeeMapper{
	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}*/
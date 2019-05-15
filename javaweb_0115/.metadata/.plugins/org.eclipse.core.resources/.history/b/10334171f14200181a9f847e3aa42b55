package com.atguigu.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

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
	
	public Employee getEmployeeByIdAndLastName(@Param("id")Integer id , @Param("lastName")String lastName );
	
	public Employee getEmployeeByMap( Map<String,Object> map  );
	
	public List<Employee> getEmps();
	
	public  Map<String, Object>   getEmployeeByIdReturnMap(Integer id );
	
	@MapKey("id")  // 指定的是对象的某个属性名. 
	public  Map<Integer, Employee >  getEmpsReturnMap();
	
}



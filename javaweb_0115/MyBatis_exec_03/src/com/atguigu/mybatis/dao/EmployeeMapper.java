package com.atguigu.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.beans.Employee;

public interface EmployeeMapper {
	
    //select
	public Employee getEmployeeById(Integer id );
	//insert
	public Integer  addEmployee(Employee employee);
	//update
	public Long  updateEmployee(Employee employee);
	//delete
	public Boolean  deleteEmployeeById(Integer id );
	/*
	 * many params & use annotation @Param
	   select
	*/
	public Employee getEmployeeByIdAndLastName(@Param("id")Integer id , @Param("lastName")String lastName );
	/*
	 * param is a map
	 * select
	 */
	public Employee getEmployeeByMap( Map<String,Object> map  );
	/*
	 * return List
	 * select
	 */
	public List<Employee> getEmps();
	/*
	 * return Map
	 * select
	 */
	public  Map<String, Object>   getEmployeeByIdReturnMap(Integer id );
	/*
	 * return Map
	 * select
	 */
	@MapKey(value = "id")
	public  Map<Integer, Employee >  getEmpsReturnMap();
}

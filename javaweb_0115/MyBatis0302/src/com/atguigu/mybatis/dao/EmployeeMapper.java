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
	public List<Employee> getEmps();
	
	
}



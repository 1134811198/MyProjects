package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.beans.Department;

public interface DepartmentMapperResultMap {

	// 根据部门的id查询部门的数据
	public Department getDeptById(Integer id );
	
	//查询部门 并且查询部门中所有的员工信息
	
	public Department getDeptAndEmps(Integer id );
	
	public Department getDeptAndEmpsStep(Integer id );
}

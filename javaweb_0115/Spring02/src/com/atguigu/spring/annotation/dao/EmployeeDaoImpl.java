package com.atguigu.spring.annotation.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void insertEmployee() {
		System.out.println("JDBC  insert Employee .....");
	}
}

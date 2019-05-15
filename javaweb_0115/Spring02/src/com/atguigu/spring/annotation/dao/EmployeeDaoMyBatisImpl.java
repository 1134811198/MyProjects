package com.atguigu.spring.annotation.dao;

import org.springframework.stereotype.Repository;

//@Repository("employeeDao")
@Repository
public class EmployeeDaoMyBatisImpl implements EmployeeDao {

		@Override
		public void insertEmployee() {
			System.out.println("Mybatis  insert Employee ....");
		}
}

package com.atguigu.mybatis.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.beans.Employee;
import com.atguigu.mybatis.dao.EmployeeMapperResultMap;

public class TestAssosiation {
	SqlSessionFactory sqlSessionFactory;
	SqlSession session ;
	EmployeeMapperResultMap mapper;
	@Before
	public void test() throws Exception {
		String resource ="MyBatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
		mapper = session.getMapper(EmployeeMapperResultMap.class);
		System.out.println(mapper);
		
	}
	@Test
	public void test01() {
		Employee employee = mapper.getEmployeeAndDept(10);
		System.out.println(employee);
		session.commit();
	}
	@Test
	public void testStep() {
		Employee employee = mapper.getEmployeeAndDeptStep(10);
		System.out.println(employee.getEmail());
		System.out.println(employee);
	}
	@Test
	public void testReturnList() {
		List<Employee> emps = mapper.getEmpsByDid(4);
		System.out.println(emps);
	}


}

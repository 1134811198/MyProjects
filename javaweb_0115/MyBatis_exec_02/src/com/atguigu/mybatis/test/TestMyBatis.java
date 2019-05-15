package com.atguigu.mybatis.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.beans.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;

public class TestMyBatis {

	SqlSession session;
	EmployeeMapper employeeMapper;
	@Before
	public void getSqlSessionFactory() throws Exception {
		
		InputStream inputStream = Resources.getResourceAsStream("MyBatis.xml");
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
		System.out.println(session);
		employeeMapper = session.getMapper(EmployeeMapper.class);
		System.out.println(employeeMapper);
	}
	@Test
	public void testSelect() {
		Employee employee1 = employeeMapper.getEmployeeById(2);
		System.out.println(employee1);
		System.out.println("=====================");
		session.commit();
		//employeeMapper.deleteEmployeeById(100);
		//session.clearCache();
		Employee employee2 = employeeMapper.getEmployeeById(2);
		System.out.println(employee2);
		session.close();
	}
	@Test
	public void testInsert() {
		Employee employee=new Employee(null,"huihui","huihui@126.com",1);
		Integer result = employeeMapper.addEmployee(employee);
		System.out.println("result:"+result);
		Integer id = employee.getId();
		System.out.println("primarykey:"+id);
		session.commit();
		
	}
	@Test
	public void testUpdate() {
		Employee employee=new Employee(10,"hui2","hui2@126.com",0);
		Long long1 = employeeMapper.updateEmployee(employee);
		System.out.println(long1);
		session.commit();
	}
	@Test
	public void testDelete() {
		Boolean boolean1 = employeeMapper.deleteEmployeeById(11);
		System.out.println(boolean1);
		session.commit();
	}
	@Test
	public void testTwoParams() {
		Employee employee = employeeMapper.getEmployeeByIdAndLastName(6, "jerry");
		System.out.println(employee);
		session.commit();
	}
	@Test
	public void testMapParam() {
		Map<String,Object> map = new HashMap<>();
		map.put("map_id", 9);
		map.put("map_lastName", "huihui");
		map.put("map_gender", 1);
		Employee employee = employeeMapper.getEmployeeByMap(map);
		System.out.println(employee);
		session.commit();
	}
	@Test
	public void testReturnList() {
		List<Employee> emps = employeeMapper.getEmps();
		System.out.println(emps);
		session.commit();
	}
	@Test
	public void testReturnMap() {
		Map<String, Object> map = employeeMapper.getEmployeeByIdReturnMap(9);
		System.out.println(map);
		session.commit();
	}
	@Test
	public void testReturnMap2() {
		Map<Integer, Employee> map = employeeMapper.getEmpsReturnMap();
		System.out.println(map);
		session.commit();
	}


}

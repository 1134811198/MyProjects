package com.atguigu.mybatis.test;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybatis.Dao.EmployeeMapper;
import com.atguigu.mybatis.beans.Employee;

public class TestMybatis {
	
	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);
		
		return sqlSessionFactory;
	}
	/*
	 * JDBC
	 */
	@Test
	public void testJDBC() throws Exception {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println(session);
		Connection connection = session.getConnection();
		System.out.println(connection);
		String sql=
				"insert Into tbl_employee set (last_name lastName,Email,gender) values(lucky,Lucky@126.com,1)";
				
		PreparedStatement prepareStatement = 
				connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		int j = prepareStatement.executeUpdate(sql);
		ResultSet resultSet = prepareStatement.getGeneratedKeys();
		if(resultSet.next()) {
			int i = resultSet.getInt(1);
			System.out.println(i);
		}
		
		
	}
	/*
	 * insert
	 */
	@Test
	public void testInsert() throws Exception {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		Employee employee=new Employee(null, "jack", "jack@126.com", 0);
		Boolean boolean1 = employeeMapper.addEmployee(employee);
		System.out.println(boolean1);
		Integer id = employee.getId();
		System.out.println(id);
		
	}
	/*
	 * update
	 */
	@Test
	public void testUpdate() throws Exception {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
	
		Employee employee = new Employee(2, "Jerry", "tom@sina.com", 0);
		employeeMapper.updateEmployee(employee);

		 
		
	}
	/*
	 * delete
	 */
	@Test
	public void testDelete() throws Exception {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession(true);
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		employeeMapper.deleteEmployeeById(1);
	}
	/*
	 * select
	 */
	@Test
	public void testSelect() throws Exception {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		Employee employee = employeeMapper.getEmployeeById(2);
		System.out.println(employee);
		
	}
	
	
	@Test
	public void test() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);
		SqlSession session = sqlSessionFactory.openSession(); 
		try {  
			Employee employee = session.selectOne("suibian.selectEmployee", 1);
			System.out.println(employee);
			} 
		finally {  session.close(); }

	}

}

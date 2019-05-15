package com.atguigu.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybatis.beans.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;

public class TestMyBatis {
	
	@Test
	public void testSecondLevelCache() throws Exception {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session1 = ssf.openSession();
		SqlSession session2 = ssf.openSession();
		try {
			EmployeeMapper mapper1  = session1.getMapper(EmployeeMapper.class);
			EmployeeMapper mapper2 = session2.getMapper(EmployeeMapper.class);
			
			Employee employee1 = mapper1.getEmployeeById(1);
			System.out.println("employee1: " + employee1);
			System.out.println("-------------------------");
			
			session1.commit(); // close();   // 把一级缓存中的数据放到二级缓存中
			//session1.clearCache();
			
//			mapper1.deleteEmployeeById(16);
//			session1.commit();
			
			Employee employee2 = mapper2.getEmployeeById(1);
			
			System.out.println("employee2:" + employee2);
			
		} finally {
			session1.close();
			session2.close();
		}
	}
	
	
	
	
	@Test
	public void testFirstLevelCache() throws Exception {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		//SqlSession session2 = ssf.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			//EmployeeMapper mapper2 = session2.getMapper(EmployeeMapper.class);
			
			Employee employee = mapper.getEmployeeById(1);
			System.out.println("employee:" + employee);
			System.out.println(employee.hashCode()); // 1957502751
			
			System.out.println("----------------------------");
			// 增删改
			
//			mapper.deleteEmployeeById(16);
//			session.commit();
			
			//清除缓存
			//session.clearCache();
			
			Employee employee1 = mapper.getEmployeeById(1);
			System.out.println("employee1:" + employee1);
			
		} finally {
			session.close();
		}
	}
	
	
	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		
		return sqlSessionFactory;
	}
	
	

}

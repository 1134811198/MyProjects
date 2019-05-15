package com.atguigu.mybatis.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybatis.beans.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;

public class TestCache {

	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		String resource="MyBatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		 SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		 return sqlSessionFactory;
	}
	@Test
	public void testEhcache() {
		
		
	}
	@Test
	public void test() throws Exception {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session1 = sqlSessionFactory.openSession();
		System.out.println("session1============"+session1);
		EmployeeMapper mapper1 = session1.getMapper(EmployeeMapper.class);
		try {
			Employee employee1 = mapper1.getEmployeeById(2);
			System.out.println("employee1==========="+employee1);
			System.out.println(".....................................................");
		    session1.commit();
		} finally {
			session1.close();
		}
		SqlSession session2 = sqlSessionFactory.openSession();
		System.out.println("session2============"+session2);
		EmployeeMapper mapper2 = session2.getMapper(EmployeeMapper.class);
		try {
			Employee employee2 = mapper2.getEmployeeById(2);
			System.out.println("employee12============="+employee2);
			session2.commit();
		} finally {
			session1.close();
		}
		
	}

}
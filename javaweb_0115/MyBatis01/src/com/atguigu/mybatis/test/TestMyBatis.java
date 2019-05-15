package com.atguigu.mybatis.test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybatis.beans.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;

public class TestMyBatis {
	
	
	
	
	@Test
	public void testCRUD() throws Exception {
		// 获取SqlSessionFactory对象
		SqlSessionFactory ssf = getSqlSessionFactory();
		// 获取SqlSession对象
		SqlSession session = ssf.openSession();
		
		// ssf.openSession(true); 获取带自动提交的session
		try {
			// 获取EmployeeMapper接口的代理实现类对象
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			
			//查询
//			Employee employee = mapper.getEmployeeById(1);
//			System.out.println(employee);
			
			//添加
			Employee employee = new Employee(null, "Jerry", "jerry@sina.com", 0);
			Integer result = mapper.addEmployee(employee);
			System.out.println("result: " +result );
			System.out.println("主键值:" + employee.getId());
			//修改
//			Employee employee = new Employee(9, "Jerry", "tom@sina.com", 0);
//			mapper.updateEmployee(employee);
			
			//删除
//			Boolean result = mapper.deleteEmployeeById(10);
//			System.out.println("result: " +result );
			
			
			//Jdbc 插入数据获取主键值:
//			Connection conn  = null ;
//			PreparedStatement ps = conn.prepareStatement("sql",PreparedStatement.RETURN_GENERATED_KEYS);
//			int resu = ps.executeUpdate();
//			
//			ResultSet rs  = ps.getGeneratedKeys();
//			if(rs.next()) {
//				rs.getInt(1);
//			}
			
			//增删改操作必须提交
			session.commit();
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
	
	@Test
	public void testMapper()  throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);
		
		//获取SqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			//获取Mapper接口的代理实现类对象
			EmployeeMapper mapper =  session.getMapper(EmployeeMapper.class);
			Employee employee  = mapper.getEmployeeById(1);
			
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

	@Test
	public void test()  throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);
		
		//获取SqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			/**
			 * Parameters:
				statement   Unique identifier matching the statement to use.  SQL语句的唯一标识
				parameter   A parameter object to pass to the statement    执行SQL的参数
			 * 
			 */
			Employee employee  =
					 session.selectOne("com.atguigu.mybatis.dao.EmployeeMapper.selectEmployee", 1);
					
			
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

}

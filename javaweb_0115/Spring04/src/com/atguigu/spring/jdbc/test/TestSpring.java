package com.atguigu.spring.jdbc.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.atguigu.spring.jdbc.beans.Employee;
import com.atguigu.spring.jdbc.dao.*;

public class TestSpring {
	
	private JdbcTemplate jt ; 
	
	private NamedParameterJdbcTemplate npjt ; 
	
	@Test
	public void testJdbcTemplate() {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-jdbc.xml");
		
		JdbcTemplate jt = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
		
		System.out.println(jt);
	}
	
	@Before
	public void init() {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-jdbc.xml");
		jt = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
		npjt = ctx.getBean("namedParameterJdbcTemplate",NamedParameterJdbcTemplate.class);
	}
	
	/**
	 * 测试 NamedParameterJdbcTemplate
	 */
	@Test
	public void testNPJT2() {
		//模拟传入到dao中的Employee对象
		Employee employee = new Employee(null, "Erry", "girl", "0");
		String sql = "insert into tbl_employee(last_name,email,gender) values(:lastName,:email,:gender)";
		
		SqlParameterSource sps  = new BeanPropertySqlParameterSource(employee); 
		
		npjt.update(sql, sps);
	}
	@Test
	public void testNPJT() {
		
		String sql = "insert into tbl_employee(last_name,email,gender) values(:ln,:em,:ge)";
		Map<String,Object> paramMap = new HashMap<>();
		
		paramMap.put("ln", "Tom");
		paramMap.put("em", "tom@sina.com");
		paramMap.put("ge", "0");
		
		npjt.update(sql, paramMap);
	}
	
	
	
	/**
	 * query(): 查询多条数据返回多个对象的集合 
	 */
	@Test
	public void testQuery() {
		String sql ="select id, last_name lastName, email,gender from tbl_employee";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class); 
		List<Employee> emps = jt.query(sql, rowMapper);
		System.out.println(emps);
	}
	
	/**
	 * queryForObject():
	 * 	 1.查询单条数据返回单个对象
	 *   2.查询单值
	 */
	@Test
	public void testQueryForObjectReturnSingleValue() {
		String sql = "select count(id) from tbl_employee"; 
		
		Integer result = jt.queryForObject(sql, Integer.class);
		System.out.println(result);
	}
	
	
	@Test
	public void testQueryForObjectReturnSingleObject() {
		String sql = "select id,last_name,email,gender from tbl_employee where id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class); 
		Employee employee =  jt.queryForObject(sql, rowMapper, 1);
		System.out.println(employee);
	}
	
	
	/**
	 * batchUpdate(): 批量增删改
	 * 
	 * 作业: 批量 删  改
	 */
	@Test
	public void testBatchUpdate() {
		String sql = "insert into tbl_employee(last_name,email,gender) values(?,?,?)";
		
		List<Object[] > batchArgs = new ArrayList<Object [] > ();
		
		batchArgs.add(new Object[] {"张三丰","zsf@sina.com","1"});
		batchArgs.add(new Object[] {"张翠山","zcs@sina.com","1"});
		batchArgs.add(new Object[] {"张无忌","zwj@sina.com","1"});
		
		
		jt.batchUpdate(sql, batchArgs);
	}
	
	
	/**
	 * update(): 完成增删改操作
	 * 
	 * 作业:  删   改
	 */
	@Test
	public void testUpdate() {
		String sql="insert into tbl_employee(last_name,email,gender) values(?,?,?)";
		//JDBC: 获取连接  预编译sql  设置参数  执行SQL  封装结果集   关闭连接 
		jt.update(sql, "社会刚哥222","gg@atguigu.com","1");
		
	}
}

package com.atguigu.Spring.JdbcTemplate;

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



public class TestJdbcTemplateDataSource {
	JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate npjt;
	@Before
	public void init() {
		
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("JdbcTemplateDataSource.xml");
		     jdbcTemplate = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
		     npjt = ctx.getBean("namedParameterJdbcTemplate",NamedParameterJdbcTemplate.class);
		     System.out.println(jdbcTemplate);
		     System.out.println(npjt);
		     
	}
	@Test
	public void testSalary() {
		
		String sql="update emp1 set salary = ? where employee_id = ?";
		jdbcTemplate.update(sql, 300000.00,"100");
	}
	/*
	 * 实验3：批量插入
	 */
	@Test
	public void testBatch() {
		String sql="insert into newemp(name,sex) values(?,?)";
		List<Object []> batchargs=new ArrayList<>();
		
		batchargs.add(new Object [] {"Tom333","man"});
		batchargs.add(new Object [] {"Jerry333","woman"});
		batchargs.add(new Object [] {"Jerry333","woman"});
		jdbcTemplate.batchUpdate(sql, batchargs);
		
	}
	/*
	 * 实验4：查询id=2的数据库记录，封装为一个Java对象返回
	 */
	@Test
	public void testQueryForSingleObject() {
		String sql="select name,sex from newemp where id = ? ";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(employee);
	}
	/*
	 * 实验5：查询所有员工的数据库记录，封装为List集合返回
	 */
	@Test
	public void testQueryForList() {
		String sql="select name,sex from newemp ";
		BeanPropertyRowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		List<Employee> list = jdbcTemplate.query(sql, rowMapper);
		System.out.println(list);
	}
	/*
	 * 实验6：查询最大salary
	 */
	/**
	 * 测试 NamedParameterJdbcTemplate,以SqlParameterSource形式传入参数值
	 */
	@Test
	public void testNPJT2() {
		
		Employee employee = new Employee("Jerry22",  "woman");
		String sql = "insert into newemp(name,sex) values(:name,:sex)";
		
		SqlParameterSource sps  = new BeanPropertySqlParameterSource(employee); 
		
		npjt.update(sql, sps);
	}
	/*
	 * 实验6：查询最大salary
	 */
	@Test
	public void testMax() {
		String sql="select max(salary) from emp1";
		Double max = jdbcTemplate.queryForObject(sql, Double.class);
		System.out.println(max);
	}
	/*
	 * 实验7：使用带有具名参数的SQL语句插入一条员工记录，并以Map形式传入参数值
	 * 
	 */
	@Test
	public void testNPJT() {
		String sql="insert into newemp(name,sex) values(:name,:sex)";
		Map<String,Object> map=new HashMap<>();
		map.put("name", "Lucy");
		map.put("sex", "woman");
		npjt.update(sql, map);
	}
	/*
	 * 实验8：重复实验7，以SqlParameterSource形式传入参数值
	 */
	@Test
	public void test08() {
		String sql="insert into newemp(name,sex) values(:name,:sex)";
		Employee emp=new Employee("lili","girl");
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(emp);
		npjt.update(sql, sqlParameterSource);
	}

}

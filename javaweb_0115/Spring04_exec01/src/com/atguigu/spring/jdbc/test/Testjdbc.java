package com.atguigu.spring.jdbc.test;



import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.atguigu.spring.jdbc.beans.Employee;

public class Testjdbc {
	JdbcTemplate jdbcTemplate;
@Before
public void init() {
	ApplicationContext ctx=
			new ClassPathXmlApplicationContext("JdbcTemplate.xml");
	 jdbcTemplate = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
	System.out.println(jdbcTemplate);

}
@Test
public void test01() {
	String sql="insert into tbl_employee(last_name,email,gender) values(?,?,?)";
	jdbcTemplate.update(sql, "Tom","tom@126.com","1");
}
@Test
public void test02() {
	String sql="insert into tbl_employee(last_name,email,gender)values(?,?,?)";
	
	List<Object[]> batchArgs=new ArrayList<Object[]>();
	batchArgs.add(new Object[] {"张三丰","zsf@sina.com","1"});
	batchArgs.add(new Object[] {"张丰","zf@sina.com","1"});
	batchArgs.add(new Object[] {"张三","zs@sina.com","1"});
	jdbcTemplate.batchUpdate(sql, batchArgs);
}
@Test
public void test03() {
	String sql="select id,last_name,email,gender from tbl_employee where id=?";
	
	RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class); 
	Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
	System.out.println(employee);
	
}
@Test
public void test04() {
	
	String sql="select count(id) from tbl_employee";
	Integer queryForObject = jdbcTemplate.queryForObject(sql, Integer.class);
	System.out.println(queryForObject);
}
}

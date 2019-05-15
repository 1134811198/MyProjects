package com.atguigu.spring.dataSource;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	@Test
	public void testDataSource() throws Exception {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-dataSource.xml");
		
		DataSource ds = ctx.getBean("dataSource",DataSource.class);
		
		System.out.println("ds:" + ds );
		Connection connection = ds.getConnection();
		System.out.println(connection);
		
		
		
	}

}

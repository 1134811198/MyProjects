package com.atguigu.spring.scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	@Test
	public void testScope() {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-scope.xml");
		
		Employee employee = ctx.getBean("employee",Employee.class);
//		
		Employee employee1 = ctx.getBean("employee",Employee.class);
//		
		System.out.println(employee == employee1);
	}

}

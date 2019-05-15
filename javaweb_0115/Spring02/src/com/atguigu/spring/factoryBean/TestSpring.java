package com.atguigu.spring.factoryBean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	@Test
	public void testFactoryBean() {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-factorybean.xml");
		Employee employee = ctx.getBean("employee",Employee.class);
		System.out.println("employee:" +employee);
	
	}

}

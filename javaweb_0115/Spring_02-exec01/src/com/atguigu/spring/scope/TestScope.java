package com.atguigu.spring.scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {

	@Test
	public void test() {
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("scope.xml");
		Employee employee = ctx.getBean("employee",Employee.class);
		System.out.println(employee);
		Employee employee2 = ctx.getBean("employee",Employee.class);
		System.out.println(employee2);
		System.out.println(employee==employee2);
		
	}

}

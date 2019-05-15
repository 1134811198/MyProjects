package com.atguigu.spring.autowire;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutowire {

	@Test
	public void test() {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("autowire.xml");
		Person person = ctx.getBean("person",Person.class);
		System.out.println(person);
	}

}

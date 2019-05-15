package com.atguigu.spring.relation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	@Test
	public void testRelation() {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-relation.xml");
		
//		Address address = ctx.getBean("address",Address.class);
//		System.out.println("address:" + address);
//		
//		Address address1 = ctx.getBean("address1",Address.class);
//		
//		System.out.println("address1:" +address1);
		
		Person person = ctx.getBean("person",Person.class);
		System.out.println(person);
		
	}

}

package com.atguigu.spring.spel;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	@Test
	public void testSPEL() {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-spel.xml");
		
		Address address = ctx.getBean("address",Address.class);
		
		System.out.println("address:" + address);
		
		Car car = ctx.getBean("car",Car.class);
		System.out.println("car:" +car );
		
		Person person = ctx.getBean("person",Person.class);
		System.out.println("person:"+ person);
	}
	
	

}

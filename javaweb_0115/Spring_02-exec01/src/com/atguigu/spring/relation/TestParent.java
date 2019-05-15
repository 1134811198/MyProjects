package com.atguigu.spring.relation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestParent {

	
	@Test
	public void test() {
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("relation.xml");
		 Address address = ctx.getBean("address2",Address.class);
		System.out.println(address);
		Person person = ctx.getBean("person",Person.class);
		System.out.println(person);
	}

}

package com.atguigu.spring.helloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		//1. 创建SpringIOC容器对象
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2. 从IOC容器对象中获取Person对象 
		//Person person = (Person)ctx.getBean("person");
		
		//Person person = ctx.getBean(Person.class);
		
		Person person = ctx.getBean("person",Person.class);
		
		//3. 调用sayHello方法. 
		
		person.sayHello();
		
	}
}

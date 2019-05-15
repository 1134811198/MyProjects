package com.atguigu.spring.lifecycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	@Test
	public void testLifeCycle() {
		
		ClassPathXmlApplicationContext ctx = 
			new ClassPathXmlApplicationContext("spring-lifecycle.xml");
			
		Employee employee = ctx.getBean("employee",Employee.class);
		
		System.out.println("==>4. 使用Bean对象 " +employee);
		
		//关闭容器
		
		ctx.close();
	
	}

}

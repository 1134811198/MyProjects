package com.atguigu.spring.annotation.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.annotation.controller.EmployeeController;
import com.atguigu.spring.annotation.dao.EmployeeDao;
import com.atguigu.spring.annotation.service.EmployeeService;

public class TestSpring {
	
	@Test
	public void testAnnotation() {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-annotation.xml");
		EmployeeController employeeController = 
				ctx.getBean("employeeController",EmployeeController.class);
		
		employeeController.regist();
		//System.out.println("employeeController: " +employeeController);
		
//		EmployeeService employeeService = 
//				ctx.getBean("employeeService",EmployeeService.class);
//		System.out.println("employeeService: "+employeeService);
//		
//		EmployeeDao employeeDao = 
//				ctx.getBean("employeeDaoImpl",EmployeeDao.class);
//		System.out.println("employeeDao: " +employeeDao);
	}
}

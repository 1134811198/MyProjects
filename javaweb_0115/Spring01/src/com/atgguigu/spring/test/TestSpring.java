package com.atgguigu.spring.test;

import java.lang.reflect.Constructor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atgguigu.spring.di.Book;
import com.atgguigu.spring.di.Department;
import com.atgguigu.spring.di.Employee;

public class TestSpring {

	@Test
	public void testDiSet() {
		//1.  创建SpringIOC容器
		ApplicationContext ctx= 
				new ClassPathXmlApplicationContext("spring-di.xml");
		//2.  从IOC容器中获取bean对象
		Employee employee = ctx.getBean("employee",Employee.class);
		//3.  使用bean对象. 
		System.out.println("employee: " +employee );
		
	}
	
	@Test
	public void testDiConstructor() {
		//1.  创建SpringIOC容器
		ApplicationContext ctx= 
				new ClassPathXmlApplicationContext("spring-di.xml");
		//2.  从IOC容器中获取bean对象
		Employee employee1 = ctx.getBean("employee1",Employee.class);
		//3.  使用bean对象. 
		System.out.println("employee1: " +employee1 );
		
		Employee employee2  = ctx.getBean("employee2",Employee.class);
		System.out.println("employee2: " + employee2);
		
	}
	
	@Test
	public void testEmployeeConstructor() {
		//获取Employee所有的构造器
		
		Class cls = Employee.class;
		
		Constructor[] cons = cls.getDeclaredConstructors();
		for (Constructor con : cons) {
			//获取到构造器的参数列表
			Class [] params = con.getParameterTypes();
			for (Class c : params) {
				System.out.print(c.getName() +"  ");
			}
			
			System.out.println();
		}
	}
	
	@Test
	public void testDi() {
		//1.  创建SpringIOC容器
		ApplicationContext ctx= 
				new ClassPathXmlApplicationContext("spring-di.xml");
		
		Book book = ctx.getBean("book",Book.class);
		System.out.println("book:" + book);
		
		Employee employee3 = ctx.getBean("employee3",Employee.class);
		System.out.println("employee3: " + employee3 );
		System.out.println("employee3 dept: " + employee3.getDept());
		
		Employee employee4 = ctx.getBean("employee4",Employee.class);
		System.out.println("employee4: " + employee4 );
		System.out.println("employee4 dept: " + employee4.getDept());
		
		
		Department dept1 = ctx.getBean("dept1",Department.class);
		System.out.println("dept1: " + dept1);
		
		Employee employee5 = ctx.getBean("employee5",Employee.class);
		System.out.println("employee5: " + employee5 );
		System.out.println("employee5 dept: " + employee5.getDept());
		
		Department dept2 = ctx.getBean("dept2",Department.class);
		System.out.println("dept2: " + dept2);
		System.out.println("dept2 emps: " + dept2.getEmps());
		
		Department dept3 = ctx.getBean("dept3",Department.class);
		System.out.println("dept3: " + dept3);
		System.out.println("dept3 emps: " + dept3.getMapEmps());
		
		
		
	}
	
	
	

}

package com.atguigu.spring.aspectJ;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	@Test
	public void testAop() {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-aspectJ.xml");
		
		//获取代理对象
		ArithmeticCalculator ac  = 
				ctx.getBean("arithmeticCalculatorImpl",ArithmeticCalculator.class);
		System.out.println("ac: "  + ac.getClass().getName());
		int result = ac.add(1,2);
		
		System.out.println("result: " +result );
		
		//result = ac.div(1, 0);
		
	}

}

package com.atguigu.Spring.aspectJ.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;





public class TestSpring {

	/*@Test
	public void test() {
	
		//Proxy
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("SpringAspect.xml");
				注意：Proxy代理类不能强转成目标对象impl类
		ArithmeticCalculatorImpl ac = 
				ctx.getBean("arithmeticCalculatorImpl",ArithmeticCalculatorImpl.class);
		System.out.println(ac.getClass().getName());
		
		int result = ac.add(1, 2);
        System.out.println(result);	
	}
	*/
	@Test
	public void testAop() {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("SpringAspect.xml");
		
		//获取代理对象
		ArithmeticCalculator ac  = 
				ctx.getBean("arithmeticCalculatorImpl",ArithmeticCalculator.class);
		
		System.out.println("ac: "  + ac.getClass().getName());
		int result = ac.add(1,2);
		
		System.out.println("result: " +result );

    }
	@Test
	public void testAop2() {
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("SpringAspect.xml");
		System.out.println(ctx);
        ArithmeticCalculator ac=
        		ctx.getBean("arithmeticCalculatorImpl",ArithmeticCalculator.class);
        String name = ac.getClass().getName();
        System.out.println(name);
        int sub = ac.sub(3, 2);
        System.out.println(sub);
	
	}


}

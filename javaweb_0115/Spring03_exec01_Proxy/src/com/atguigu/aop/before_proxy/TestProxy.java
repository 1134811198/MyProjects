package com.atguigu.aop.before_proxy;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProxy {

	@Test
	public void test() {
		
		//目标对象
				ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		//代理对象
				ArithmeticCalculatorProxy arithmeticCalculatorProxy = new ArithmeticCalculatorProxy(target);
				Object obj = arithmeticCalculatorProxy.getProxy();
			
				ArithmeticCalculator proxy=(ArithmeticCalculator) obj;
				System.out.println(proxy.getClass().getName());
				int result = proxy.add(1, 1);
				
				System.out.println(result);
				
				
				
				
				
	}

}

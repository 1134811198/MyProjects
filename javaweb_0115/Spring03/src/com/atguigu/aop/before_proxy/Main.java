package com.atguigu.aop.before_proxy;

import java.util.Properties;

public class Main {
	public static void main(String[] args) {
		
		 Properties properties = System.getProperties();
		 properties.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

		
		//目标对象
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		
		//代理对象
		
		Object  obj = new ArithmeticCalculatorProxy(target).getProxy();
		
		ArithmeticCalculator proxy = (ArithmeticCalculator)obj ;
		System.out.println(proxy.getClass().getName()); //com.sun.proxy.$Proxy0
		
		//问题1 : 代理对象可否强制转换成目标对象的类型?  不可以. 
		//问题2 : 为什么代理对象调用方法， 会回去调用invoke方法
		
		
		
		//所有对目标对象方法的调用都要通过代理对象.
		int result =proxy.add(1, 1);  // 回去调用InvocationHandler中的invoke方法
		
		System.out.println("result: "  + result );
	}
}

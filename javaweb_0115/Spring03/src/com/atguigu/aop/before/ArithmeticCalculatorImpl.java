package com.atguigu.aop.before;

public class ArithmeticCalculatorImpl implements ArithmeticCalculator{

	@Override
	public int add(int i, int j) {
		// 记录日志
		System.out.println("Atguigu Logging==>The method  add begin with ["+i+","+j+"]");
		int result =  i + j ;  // 核心业务
		// 记录日志
		System.out.println("Atguigu Logging==>The method  add end  with : " + result);
		return result ;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println("Atguigu Logging==>The method  sub begin with ["+i+","+j+"]");
		int result =  i - j ; 
		System.out.println("Atguigu Logging==>The method  sub end  with : " + result);
		return result ;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("Atguigu Logging==>The method  mul begin with ["+i+","+j+"]");
		int result =  i * j ; 
		System.out.println("Atguigu Logging==>The method  mul end  with : " + result);
		return result ;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("Atguigu Logging==>The method  div begin with ["+i+","+j+"]");
		int result =  i / j ; 
		System.out.println("Atguigu Logging==>The method  div end  with : " + result);
		return result ;
	}
}

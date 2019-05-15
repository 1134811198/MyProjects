package com.atguigu.spring.aspectJ_xml;

import org.springframework.stereotype.Component;

public class ArithmeticCalculatorImpl implements ArithmeticCalculator{

	@Override
	public int add(int i, int j) {
		int result =  i + j ;  // 核心业务
		return result ;
	}

	@Override
	public int sub(int i, int j) {
		int result =  i - j ; 
		return result ;
	}

	@Override
	public int mul(int i, int j) {
		int result =  i * j ; 
		return result ;
	}

	@Override
	public int div(int i, int j) {
		int result =  i / j ; 
		return result ;
	}
	
}

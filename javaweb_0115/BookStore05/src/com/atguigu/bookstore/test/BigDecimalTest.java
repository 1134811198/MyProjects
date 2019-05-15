package com.atguigu.bookstore.test;

import java.math.BigDecimal;

import org.junit.Test;



public class BigDecimalTest {

	@Test
public	void test() {
		BigDecimal a = new BigDecimal(1);
		BigDecimal b = new BigDecimal(1);
		//加
		BigDecimal add = a.add(b);
		System.out.println(add);
		//减
		BigDecimal subtract = a.subtract(b);
		System.out.println(subtract);
		//乘
		BigDecimal multiply = a.multiply(b);
		System.out.println(multiply);
		//除
		BigDecimal divide = a.divide(b);
		System.out.println(divide);
		//计算double的数，使用String类型的构造器
		BigDecimal c = new BigDecimal("0.01");
		BigDecimal d = new BigDecimal("0.09");
		BigDecimal add2 = c.add(d);
		System.out.println(add2);
	}

}

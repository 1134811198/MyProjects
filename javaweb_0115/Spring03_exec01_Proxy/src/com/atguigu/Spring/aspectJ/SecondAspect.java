package com.atguigu.Spring.aspectJ;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(5)
public class SecondAspect {
  
	
	
	//@Before("execution(* com.atguigu.Spring.aspectJ.*.add(..))")
	@Before("LoggingAspect.declaredPointcut()")
	public void beforeMethod() {
		System.out.println("SecondAspect"+" starting ");
	}
}

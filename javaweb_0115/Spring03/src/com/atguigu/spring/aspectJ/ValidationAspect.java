package com.atguigu.spring.aspectJ;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class ValidationAspect {
	/**
	 * 前置通知
	 */
	//@Before("execution(* com.atguigu.spring.aspectJ.*.*(..))")
	@Before("LoggingAspect.declaredPointCut()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();
		
		System.out.println("ValidationAspect==>The method " + methodName + " begin  with " + Arrays.asList(args));
		
	}
}

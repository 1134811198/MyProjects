package com.atguigu.spring.aspectJ_xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class ValidationAspect {
	/**
	 * 前置通知
	 */
	//@Before("execution(* com.atguigu.spring.aspectJ.*.*(..))")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();
		
		System.out.println("ValidationAspect==>The method " + methodName + " begin  with " + Arrays.asList(args));
		
	}
}

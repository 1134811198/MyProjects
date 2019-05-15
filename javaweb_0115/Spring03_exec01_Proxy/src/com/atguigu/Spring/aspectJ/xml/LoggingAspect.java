package com.atguigu.Spring.aspectJ.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切面类
 * 对于AOP来讲，重要的编程对象是切面
 * 对于切面来讲，重要的编程对象就是通知. 
 */
@Component
@Aspect
@Order(3)
public class LoggingAspect {
	
	
	/*
	 * 声明切入点
	 */
	@Pointcut("execution(* com.atguigu.Spring.aspectJ.*.*(..))")
	public void declaredPointcut() {
		
	}
/*
 * 前置通知
 */
	@Before(value = "execution(public int com.atguigu.Spring.aspectJ.ArithmeticCalculatorImpl.add(int,int))")
	public void beforeMethod(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(methodName+"starting with"+ Arrays.asList(args));
	}
	
	/*
	 * 后置通知
	 */
    @After("declaredPointcut()")
     public void afterMethod(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(methodName+"ending with"+ Arrays.asList(args));
	 }
	/*
	 * 后置返回通知
	 */
    @AfterReturning(value="declaredPointcut()",returning="result")
    public void AfterReturningMethod(JoinPoint joinPoint,Object result) {
    	String methodName = joinPoint.getSignature().getName();
    	Object[] args = joinPoint.getArgs();
    	System.out.println(methodName+"args:"+Arrays.asList(args)+" ending with"+result);	
    }
	/*
	 * 异常通知
	 */
	/*
	 * 环绕通知
	 */
}

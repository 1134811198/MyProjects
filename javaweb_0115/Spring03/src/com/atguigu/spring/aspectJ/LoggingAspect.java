package com.atguigu.spring.aspectJ;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
@Component  // 标识为一个受Spring管理的组件
@Aspect  //标识为一个切面
@Order(3)  // 值越小，优先级越高.    0x7fffffff   01111111 11111111 11111111 11111111
public class LoggingAspect {
	
	/**
	 * 定义切入点表达式
	 */
	@Pointcut("execution( * com.atguigu.spring.aspectJ.*.*(..))")
	public void declarePointCut() {}
	
	/**
	 * 前置通知: 在目标对象的方法之前执行. 
	 * 
	 * joinPoint: 连接点对象. 会将当前连接点(目标类的方法)的相关信息封装起来. 
	 */
	//@Before("execution(public int com.atguigu.spring.aspectJ.ArithmeticCalculatorImpl.add(int,int))")
	@Before("declarePointCut()")
	public  void  beforeMethod(JoinPoint joinPoint) {
		
		//获取方法的名字
		String methodName  = joinPoint.getSignature().getName();
		//获取方法的参数
		Object [] args = joinPoint.getArgs();
		
		System.out.println("LoggingAspect==> The method "+methodName+" begin with "+Arrays.asList(args));
	}
	
	
	/**
	 * 后置通知: 在目标对象的方法之后执行. 不管目标方法有没有抛出异常都会执行
	 *  * com.atguigu.spring.aspectJ.ArithmeticCalculatorImpl.*(..)
	 *  * : 任意修饰符 任意返回值
	 *  * : 任意类
	 *  * : 任意方法名
	 *  ..: 任意参数列表
	 */
	//@After("execution( * com.atguigu.spring.aspectJ.*.*(..))")
	@After("declarePointCut()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName  = joinPoint.getSignature().getName();
		System.out.println("LoggingAspect==> The method " + methodName + " ends .");
	}
	
	/**
	 * 返回通知: 在目标对象的方法正确执行结束后执行.  可以获取到目标方法的返回值. 
	 * 
	 * 获取方法的返回值:  要求returning指定的名字一定要与通知方法中的参数名一致.
	 */
	@AfterReturning(value="execution( * com.atguigu.spring.aspectJ.*.*(..))",returning="result")
	public void afterReturningMethod(JoinPoint joinPoint,Object result ) {
		String methodName  = joinPoint.getSignature().getName();
		
		System.out.println("LoggingAspect==>The method " + methodName +" end with :" +result  );
	}
	
	/**
	 * 异常通知:  在目标对象的方法抛出异常以后执行. 
	 * 
	 * 获取异常信息:  要求throwing指定的名字一定要与通知方法 中的参数名一致. 
	 * 
	 * 其实也可以设置抛出指定异常后再执行异常通知. 通过通知方法中的异常参数的类型来设置. 
	 * 
	 */
	@AfterThrowing(value="execution( * com.atguigu.spring.aspectJ.*.*(..))",throwing="ex")
	public void afterThrowingMethod(JoinPoint joinPoint,ArithmeticException ex ) {
		String methodName  = joinPoint.getSignature().getName();
		
		System.out.println("LoggingAspect==>The method "+ methodName +" occurs Exception: " + ex );
	}
	
	
	/**
	 * 环绕通知:环绕着目标对象的方法执行. 可以理解为是 前置 后置  返回 异常通知的结合体. 更像是动态代理的整个过程。 
	 */
	
	//@Around("execution( * com.atguigu.spring.aspectJ.*.*(..))")
	public Object  aroundMethod(ProceedingJoinPoint pjp) {
		try {
			//前置
			
			//执行目标对象的方法
			Object result = pjp.proceed();  
			
			//返回
			
			return result ;
		} catch (Throwable e) {
			
			//异常
			e.printStackTrace();
		}finally {
			//后置
		}
		
		return null ;
	}
	
	
	
	
	
	
	
	
}

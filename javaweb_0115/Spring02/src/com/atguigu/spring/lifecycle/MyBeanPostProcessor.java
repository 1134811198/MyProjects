package com.atguigu.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * bean的后置处理器
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
	
	/**
	 * 在初始化方法之前执行
	 * Object bean:
	 * String beanName: 
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("postProcessBeforeInitialization");
		
		return bean;
	}
	/**
	 * 在初始化方法之后执行. 
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization");
		return bean;
	}
		
}

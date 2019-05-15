package com.atguigu.spring.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 工厂bean
 */
public class MyFactoryBean implements FactoryBean<Employee> {
	
	/**
	 * 工厂bean具体返回的对象.
	 */
	@Override
	public Employee getObject() throws Exception {
		return  new Employee(1001,"Jerry");
	}

	@Override
	public Class<?> getObjectType() {
		return Employee.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}

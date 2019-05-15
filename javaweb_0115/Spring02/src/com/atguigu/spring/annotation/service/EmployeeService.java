package com.atguigu.spring.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.atguigu.spring.annotation.dao.EmployeeDao;

@Service
public class EmployeeService {
	/**
	 * @AutoWired 工作机制:
	 * 	首先会使用byType的方式来进行装配，如果能唯一匹配，则装配成功，如果匹配到多个兼容类型的bean，
	 * 	还会进一步使用byName的方式进行唯一的确定. 如果能唯一确定，则装配成功， 否则，抛出异常。 
	 * @Qualifier("id值")：进一步指定要装配的bean的id值
	 * 
	 * @Autowired 默认情况下必须要进行装配， 可以使用required=false来设置不是必须的. 
	 * 
	 * @Autowired 或者是@Qualifier 即可以加在属性上， 也可以加在对应的set方法上. 
	 * 
	 * 
	 */
	@Autowired(required=false)   // <property  name="employeeDao" ref="employeeDaoImpl">
	//@Qualifier("employeeDaoMyBatisImpl")  //进一步指定要装配的bean的id值. 
	private EmployeeDao employeeDao ;
	
	//@Autowired(required=false)   // <property  name="employeeDao" ref="employeeDaoImpl">
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public void  insertEmployee() {
		employeeDao.insertEmployee();
	}
}

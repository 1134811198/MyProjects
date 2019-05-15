package com.atguigu.spring.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.atguigu.spring.annotation.service.EmployeeService;

/**
 *  加上 @Controller 注解 就相当于在xml文件中做如下的配置:
 *  <bean id="employeeController" class="com.atguigu.spring.annotation.controller.EmployeeController"></bean>
 * 
 *  默认情况下，@Controller 将组件管理到IOC容器中， 使用的id就是类名首字母小写. 
 *  我们也可以具体去指定一个id值，  @Controller(value="id值"), 可以在简化一点就是
 *  直接在扩号中给定id值就可以@Controller("id值")
 *  给注解的value属性赋值，可以省略value= 的指定. 
 *
 */
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService ; 
	
	public void regist() {
		employeeService.insertEmployee();
	}
	

}

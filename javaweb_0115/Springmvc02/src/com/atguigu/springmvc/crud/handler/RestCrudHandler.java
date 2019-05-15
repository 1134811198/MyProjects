package com.atguigu.springmvc.crud.handler;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.springmvc.crud.beans.Employee;
import com.atguigu.springmvc.crud.dao.EmployeeDao;

@Controller
public class RestCrudHandler {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	/**
	 * 查询所有的员工信息， 列表展示
	 */
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String  listAllEmps(Map<String,Object> map ) {
		//查询所有的员工信息
		Collection<Employee> emps = employeeDao.getAll();
		map.put("emps", emps);
		
		return "list";
	}
}

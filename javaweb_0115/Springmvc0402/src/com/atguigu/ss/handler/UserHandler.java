package com.atguigu.ss.handler;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atguigu.ss.beans.Person;
import com.atguigu.ss.service.UserService;

@Controller
public class UserHandler {
	
	@Autowired
	private UserService userService ; 
	
	public UserHandler() {
		System.out.println("UserHandler.....");
	}
	
	@RequestMapping("/testSS")
	public String  testSS(HttpSession session) {
		
		ServletContext sc = session.getServletContext();
//		ApplicationContext ctx =
//				(ApplicationContext) sc.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
		
		Person person = ctx.getBean("person",Person.class);
		person.sayHello();
		
		//service 
		userService.addUser();
		
		return "success";
	}
}

package com.atguigu.Springss.Springmvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.Springss.Service.UserService;

@Controller
public class UserHandler {
    @Autowired
	UserService userService;
    
	public UserHandler() {
      System.out.println("Userhandler...");
	}

	@RequestMapping("/TestSpringss")
	public String addUser() {
		userService.addUser();
		return "success";
		
	}
}

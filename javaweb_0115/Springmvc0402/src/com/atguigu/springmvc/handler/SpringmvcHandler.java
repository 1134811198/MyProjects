package com.atguigu.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringmvcHandler {
	
	@RequestMapping("/testSpringmvc")
	public String testSpringmvc() {
		return "success";
	}
}
package com.atguigu.Springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringmvcHandler {
	@RequestMapping("/hello")
   public String handleHello() {
	   System.out.println("Spring HelloWorld");
	   return "success";
   }
}

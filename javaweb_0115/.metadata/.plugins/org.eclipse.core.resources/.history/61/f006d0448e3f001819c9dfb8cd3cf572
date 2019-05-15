package com.atguigu.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringmvcHandler {

	/**
	 * @RequestHeader
	 */
	@RequestMapping("/TestRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language")String acceptLanguage) {
		System.out.println(acceptLanguage);
		
		return "success";
		
	}
	/*
	 * @RequestParam
	 */
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam("username")String username, 
				@RequestParam(value="age",required=false,defaultValue="0")int  age ) {
		System.out.println(username + " , " +age );
		
		return "success";
	}
	


}


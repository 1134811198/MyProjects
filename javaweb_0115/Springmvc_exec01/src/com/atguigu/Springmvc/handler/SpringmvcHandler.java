package com.atguigu.Springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringmvcHandler {

	@RequestMapping("/hello")
	public String handleHello() {
		System.out.println("Hello Springmvc");
		return "success";
		
	}
   @RequestMapping(value="/TestRequestMappingPostMethod",method= {RequestMethod.POST})
	public String handleTest01() {
		
		return "success";
	}
   @RequestMapping(value="/TestRequestMappingParams",params= {"username","age=10"})
   public String handleTest02() {
	   return "success";
   }
   @RequestMapping(value="/TestRequestMappingHeaders",headers= {"Accept-Language"})
   public String handleTest03() {
	   return "success";
   }
   @RequestMapping(value="/TestRequestMappingAnt/?/test.???")
   public String handleTest04() {
	   return "success";
   }
   @RequestMapping("/TestRequestMappingPathVariable/{username}/{id}/{gender}")
   public String handleTest05(@PathVariable("username")String username,@PathVariable("id")Integer id,@PathVariable("gender")String gender) {
	   return "success";
   }
   @RequestMapping(value="/order/{id}", method= {RequestMethod.GET})
   public String handleTest06(@PathVariable("id")Integer id) {
	   System.out.println("id1111="+id);
	   return "success";
   }
   @RequestMapping(value="/order" ,method= {RequestMethod.POST})
   public String handleTest07() {
	   return "success";
   }
   @RequestMapping(value="/order/{id}",method= {RequestMethod.DELETE})
   public String handleTest08(@PathVariable("id")Integer id) {
	   System.out.println("id="+id);
	   return "success";
   }
   @RequestMapping(value="/order/{id}",method= {RequestMethod.PUT})
   public String handleTest09(@PathVariable("id")Integer id) {
	   System.out.println("id:"+id);
	   return "success";
   }
}

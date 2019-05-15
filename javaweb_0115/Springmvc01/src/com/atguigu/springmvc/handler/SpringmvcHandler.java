package com.atguigu.springmvc.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 请求处理器
 */
@Controller
//@RequestMapping("/springmvc")
public class SpringmvcHandler {
	
	/**
	 * REST PUT
	 */
	@RequestMapping(value= "/order",method=RequestMethod.PUT)
	public String testRestPUT() {
		System.out.println("REST PUT ");
		return "success";
	}
	/**
	 * REST POST
	 */
	@RequestMapping(value="/order",method=RequestMethod.POST)
	public String testRestPOST() {
		System.out.println("REST POST");
		return "success";
		
	}
	/**
	 * REST DELETE
	 */
	@RequestMapping(value="/order/{id}",method=RequestMethod.DELETE)
	public String testRestDELETE(@PathVariable("id")Integer id ) {
		System.out.println("REST DELETE:" + id );
		return "success";
	}
	
	/**
	 * REST GET
	 */
	@RequestMapping(value="/order/{id}",method=RequestMethod.GET)
	public String testRestGET(@PathVariable("id")Integer id ) {
		System.out.println("REST GET:" + id );
		return "success";
	}
	
	
	/**
	 * @RequestMapping  支持带占位符的URL
	 * @PathVariable 来将URL中的占位符对应的值  映射到方法的形参中
	 * 
	 * 浏览器:  testPathVariable/tom/1001
	 * 		  testPaathVariable?username=tom&id=1001
	 */
	@RequestMapping("/testPathVariable/{username}/{id}")
	public String testPathVariable(@PathVariable("username")String username,
					@PathVariable("id") Integer id ) {
		System.out.println(username +" , " + id );
		return "success";
		
		
	}
	
	/**
	 * @RequestMapping  映射 ANT风格的资源地址
	 */
	@RequestMapping("/testRequestMappingAnt/**/test??")
	public String testRequestMappingAnt() {
		
		return "success";
	}
	
	
	/**
	 * 了解: @RequestMapping 映射请求头信息
	 */
	
	@RequestMapping(value = "/testRequestMappingHeaders", headers= {"!Accept-Language"})
	public String testRequestMappingHeaders() {
		
		return "success";
	}
	
	/**
	 * 了解:  @RequestMapping 映射请求参数
	 * 
	 */
	@RequestMapping(value="/testRequestMappingParams",params= {"username","age=10"})
	public String testRequestMappingParams() {
		
		return "success";
	}
	
	/**
	 * @RequestMapping  映射请求方式
	 */
	@RequestMapping(value="/testRequestMappingMethod",method= {RequestMethod.POST})
	public String  testRequestMappingMethod() {
		return "success";
	}
	

	/**
	 * 请求处理方法: 
	 * 浏览器: http://localhost:8888/Springmvc01/springmvc/hello
	 * 通过@RequestMapping 注解完成请求与请求处理方法的映射. 
	 * 
	 */
	@RequestMapping(value="/hello")
	public String handleHello() {
		System.out.println("Hello Springmvc ");
		return "success";  // 转发到:  /WEB-INF/views/success.jsp
	}
	
}

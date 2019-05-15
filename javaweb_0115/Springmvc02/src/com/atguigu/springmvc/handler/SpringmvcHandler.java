package com.atguigu.springmvc.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.springmvc.beans.User;

@Controller
public class SpringmvcHandler {
	/**
	 * 重定向
	 */
	@RequestMapping("/testRedirect")
	public ModelAndView testRedirect() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/ok.jsp");
		//mav.addObject("username", "tom");
		
		return mav; 
	}
	
	
	/*@RequestMapping("/testRedirect")
	public String testRedirect() {
		
		return "redirect:/ok.jsp";
	}*/
	
	/**
	 * 自定义视图
	 */
	@RequestMapping("/testMyView")
	public String testMyView() {
		return "myView";
	}
	/**
	 * Map  Model 
	 */
	
	@RequestMapping("/testModelOrMap")
	public String  testModelOrMap(Model model ) {
		//处理模型数据:  password=jiubugaosuni
		model.addAttribute("password", "jiubugaosuni");
		System.out.println(model.getClass().getName()); //BindingAwareModelMap
		
		return "success";
	}
	/*@RequestMapping("/testModelOrMap")
	public String  testModelOrMap(Map<String,Object > map ) {
		//处理模型数据:  password=jiubugaosuni
		map.put("password", "jiubugaosuni");
		System.out.println(map.getClass().getName()); //BindingAwareModelMap
		
		return "success";
	}*/
	
	/**
	 *ModelAndView
	 *
	 *结论: 存放到ModleAndView中的模型数据会被保存到request域对象中. 
	 */
	@RequestMapping("/testModelAndView")
	public  ModelAndView  testModelAndView() {
		//处理模型数据: username=Tom
		
		ModelAndView mav = new ModelAndView();
		//设置模型数据
		mav.addObject("username", "Tom");
		//设置视图信息
		mav.setViewName("success");
		
		return mav;
	}
	
	/**
	 * ServletAPI
	 * request  response  session ....
	 */
	@RequestMapping("/testServletAPI")
	public void testServletAPI(HttpServletRequest request ,HttpServletResponse response) throws Exception {
		System.out.println("request: " +request);
		System.out.println("response: " + response);
		
		//request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response); 
		// @formatter:on
		//response.sendRedirect("http://www.baidu.com");
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("Hello ServletAPI");
		
		//HttpSession session = request.getSession();
		
		//ServletContext  sc = request.getServletContext();
		
		//session.getServletContext()
		
		// 通过流的方式写给客户端数据:  JSON
	//	return "success";
	}
	
	/**
	 * POJO
	 */
	@RequestMapping("/testPOJO")
	public String testPOJO(User user) {
		System.out.println("user:" + user) ;
		return "success";
	}
	/**
	 * @CookieValue
	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID")String sessionId) {
		System.out.println("sessionId:" + sessionId);
		return "success";
	}
	
	/**
	 * @RequestHeader
	 */
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language") String acceptLanguage) {
		System.out.println("acceptLanguage:" + acceptLanguage);
		return "success";
	}
	/**
	 * 浏览器:  testRequestParam?username=tom&age=22
	 * 
	 * Servlet中如何获取请求参数?
	 * 	1. request.getParameter();
	 *  2. request.getParameterValues();
	 *  3. request.getParameterMap()
	 *  
	 * @RequestParam:
	 * 1. 	  指定将请求参数名对应的请求参数值映射到请求处理方法的形参中. 
	 * 	           如果请求参数名与请求处理方法的形参名一样，可以省略@RequestParam的指定. 建议都进行指定. 
	 * 2.    默认情况下，如果使用@RequestParam指定了获取某个参数值，但是请求中没有该参数值，则会报错
	 *       Required 类型 parameter '参数' is not present
	 *       可以通过required来设置不是必须的。 
	 * 3.    默认情况下， 如果一个可选的形参，从请求参数中获取不到对应的参数值，则Springmvc会将一个null值
	 *       赋值给该形参， 如果该形参是基本类型的，则会报错. 
	 *       可以通过defaultValue来指定一个默认值取代 null.      
	 * 
	 */
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam("username")String username, 
				@RequestParam(value="age",required=false,defaultValue="0")int  age ) {
		System.out.println(username + " , " +age );
		
		return "success";
	}
}

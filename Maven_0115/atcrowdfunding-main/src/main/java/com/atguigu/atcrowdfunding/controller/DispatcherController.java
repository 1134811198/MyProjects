package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.UserService;
import com.atguigu.atcrowdfunding.util.Const;

@Controller
public class DispatcherController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String index() {
		
		return "index";
	}
	
	
	@RequestMapping("/toLogin")
	public String toLogin() {

		return "login";
	}


	@RequestMapping("/logOut")
	public String toLogout(HttpSession session) {
		if(session != null) {
			session.removeAttribute(Const.LOGIN_USER);
			session.invalidate();
		}
		return "redirect:index.htm";
		
	}
	@RequestMapping("/main")
	public String toMain() {
		
		
		return "main";
	}
	//异步请求
	@ResponseBody
	@RequestMapping("/doLogin")
	public Object Login(String loginacct,String userpswd,String usertype,HttpSession session) {
		
		Map<String,Object> result=new HashMap<String, Object>();
		
		try {
			Map<String,Object> paramMap=new HashMap<String, Object>();
			paramMap.put("loginacct", loginacct);
			paramMap.put("userpswd", userpswd);
			paramMap.put("usertype", usertype);

			User user = userService.login(paramMap);
			session.setAttribute(Const.LOGIN_USER, user);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", e.getMessage());
			e.printStackTrace();
		}
		
		
		return result;
	}
	
/*	@RequestMapping("/doLogin")
	public String Login(String loginacct,String userpswd,String usertype,HttpSession session) {
		
		Map<String,Object> paramMap=new HashMap<String, Object>();
		paramMap.put("loginacct", loginacct);
		paramMap.put("userpswd", userpswd);
		paramMap.put("usertype", usertype);
		System.out.println(paramMap);
		
		User user = userService.login(paramMap);
		session.setAttribute(Const.LOGIN_USER, user);
		
		
		return "redirect:/main.htm";
	}*/
}

package com.atguigu.atcrowdfunding.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.UserService;
import com.atguigu.atcrowdfunding.util.Page;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String index() {
		return "user/index";
	}
	@RequestMapping("/toAdd")
	public String toAdd() {
		
		return "user/add";
	}
	@ResponseBody
	@RequestMapping("/doAdd")
	public Object doAdd(User user) {
		start();
		try {
			int count = userService.saveUser(user);
			success(count == 1);
		} catch (Exception e) {
			success(false);
			message(e.getMessage());
			e.printStackTrace();
		}
		return end();
		
	}
	@ResponseBody
	@RequestMapping("/update")
	public Object update(User user) {
		start();
		try {
			Integer id = user.getId();
			int count = userService.update(user);
			success(count == 1);
		} catch (Exception e) {
			success(false);
			message(e.getMessage());
			e.printStackTrace();
		}
		end();
		
		return end();
		
	}
	@ResponseBody
	@RequestMapping("/QueryPage")
	public Map<String, Object> QueryPage(
			@RequestParam(value = "pageno",required=false,defaultValue="1")
			Integer pageno,
			@RequestParam(value="pagesize",required=false,defaultValue="10")
			Integer pagesize,@RequestParam(value="querytext",required = false)String querytext) {
		start();
		try {
			Map<String, Object> paramMap = new HashMap();
			paramMap.put("pageno", pageno);
			paramMap.put("pagesize", pagesize);
			paramMap.put("querytext", querytext);
			Page<User> page = userService.queryPage(paramMap);
			data(page);
			success(true);
		} catch (Exception e) {
			success(false);
			message(e.getMessage());
			e.printStackTrace();
		}
		return end();
	}
	/*@ResponseBody
	@RequestMapping("/QueryPage")
	public Map<String, Object> QueryPage(
			@RequestParam(value = "pageno",required=false,defaultValue="1")
			Integer pageno,
			@RequestParam(value="pagesize",required=false,defaultValue="10")
			Integer pagesize) {
		start();
		try {
			Map<String, Object> paramMap = new HashMap();
			paramMap.put("pageno", pageno);
			paramMap.put("pagesize", pagesize);
			Page<User> page = userService.queryPage(paramMap);
			data(page);
			success(true);
		} catch (Exception e) {
			success(false);
			message(e.getMessage());
			e.printStackTrace();
		}
		return end();
	}*/
	
}

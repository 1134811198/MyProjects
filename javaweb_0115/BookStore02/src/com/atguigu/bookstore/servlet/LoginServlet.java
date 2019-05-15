package com.atguigu.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;

/**
 * 处理用户登录的Servlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//封装User对象
		User user = new User(null, username, password, null);
		//创建UserDao对象
//		UserDao userDao = new UserDaoImpl();
		//调用UserDao中验证用户名和密码的方法
//		User user2 = userDao.getUser(user);
		//调用UserService中处理用户登录的方法
		User login = userService.login(user);
		if(login != null) {
			//用户名和密码正确，重定向到登录成功页面
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.html");
		}else {
			//用户名或密码不正确，转发到登录页面
			request.getRequestDispatcher("/pages/user/login.html").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

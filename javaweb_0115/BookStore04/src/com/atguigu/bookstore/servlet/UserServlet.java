package com.atguigu.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;

/**
 * 处理用户登录和注册的Servlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	//注销方法
	
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	// 处理用户注册的方法
	protected void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户名、密码、邮箱
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		// 封装User对象
		User user = new User(null, username, password, email);
		// 创建UserDao对象
		// UserDao userDao = new UserDaoImpl();
		// 调用UserDao中验证用户名的方法
		// boolean flag = userDao.checkUsername(user);
		// 调用UserService中处理用户注册的方法
		boolean flag = userService.regist(user);
		if (!flag) {
			// 用户名已存在，设置一个提示信息并放到request域中
			request.setAttribute("msg", "用户名已存在！");
			// 转发到注册页面
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		} else {
			// 用户名可用，将User对象保存到数据库中
			userService.saveUser(user);
			// 重定向到注册成功页面
			response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
		}
	}

	// 处理用户登录的方法
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 封装User对象
		User user = new User(null, username, password, null);
		// 创建UserDao对象
		// UserDao userDao = new UserDaoImpl();
		// 调用UserDao中验证用户名和密码的方法
		// User user2 = userDao.getUser(user);
		// 调用UserService中处理用户登录的方法
		User login = userService.login(user);
		if (login != null) {
			// 用户名和密码正确，重定向到登录成功页面
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
		} else {
			// 用户名或密码不正确，设置一个提示信息并放到request域中
			request.setAttribute("msg", "用户名或密码不正确！");
			// 转发到登录页面
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}
	}

}

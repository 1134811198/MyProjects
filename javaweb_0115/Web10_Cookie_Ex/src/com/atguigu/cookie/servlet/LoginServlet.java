package com.atguigu.cookie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理免登录的Servlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//假设用户名和密码正确，创建两个Cookie对象保存用户名和密码
		Cookie userCookie = new Cookie("username", username);
		Cookie pwdCookie = new Cookie("password", password);
		//将两个Cookie的有效时间设置为7天
		userCookie.setMaxAge(60);
		pwdCookie.setMaxAge(60);
		//将两个Cookie对象发送给浏览器
		response.addCookie(userCookie);
		response.addCookie(pwdCookie);
		//重定向到登录成功页面
		response.sendRedirect(request.getContextPath()+"/success.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

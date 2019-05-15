package com.atguigu.cookie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 修改Cookie对象的Servlet
 */
public class ModifyCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//方式一：创建一个同名的Cookie对象
//		Cookie cookie = new Cookie("user", "superAdmin");
		//将Cookie对象发送给浏览器
//		response.addCookie(cookie);
		//方式二：直接修改Cookie对象的value值
		//获取Cookie对象
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				//获取Cookie对象的名字
				String name = cookie.getName();
				if("user".equals(name)) {
					//修改该Cookie对象的value值
					cookie.setValue("ssuperAdmin");
					//将修改之后的Cookie对象发送给浏览器
					response.addCookie(cookie);
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.atguigu.cookie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建Cookie对象的Servlet
 */
public class CreateCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.创建Cookie对象
		/*Cookie对象的名字只能使用英文，Cookie对象的值可以使用中文但是需要指定字符集进行编码，
		在获取时也需要指定字符集进行解码，比较麻烦，所以建议使用英文即可*/
		Cookie cookie = new Cookie("user", "admin");
		Cookie cookie1 = new Cookie("username", "zhangsan");
		Cookie cookie2 = new Cookie("password", "123456");
		Cookie cookie3 = new Cookie("age", "20");

		//2.将Cookie对象发送给浏览器
		response.addCookie(cookie);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

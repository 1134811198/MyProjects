package com.atguigu.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doGet!!!!!");
	String parameter = request.getParameter("username");
	String parameter2 = request.getParameter("password");
	System.out.println(parameter);
	System.out.println(parameter2);
	//给浏览器响应
	response.setContentType("text/html;charset=UTF-8");
	response.getWriter().write("响应成功");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doPost!!!!!!");
	}

}

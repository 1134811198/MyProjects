package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServletConfig implements Servlet{
	private ServletConfig config;
	



	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String servletName = config.getServletName();
		System.out.println("servlet"+servletName);
		String initParameter = config.getInitParameter("user");
		System.out.println("initParamiter"+initParameter);
		ServletContext servletContext = config.getServletContext();
		String initParameter2 = servletContext.getInitParameter("encoding");
		System.out.println("servletContext"+initParameter2);
		String realPath = servletContext.getRealPath("/index.html");
		System.out.println("realPath"+realPath);
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

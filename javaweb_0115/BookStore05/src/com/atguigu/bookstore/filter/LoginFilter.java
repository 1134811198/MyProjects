package com.atguigu.bookstore.filter;

import com.atguigu.bookstore.beans.User;
import com.atguigu.filter.HttpFilter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用于验证用户是否登陆
 */
public class LoginFilter extends HttpFilter implements Filter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null) {
			chain.doFilter(request, response);
		}else {
			request.setAttribute("msg", "请先登陆");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			
		}
	}



}

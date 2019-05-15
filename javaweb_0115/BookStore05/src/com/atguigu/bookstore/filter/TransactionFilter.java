package com.atguigu.bookstore.filter;

import com.atguigu.bookstore.utils.JDBCUtils;
import com.atguigu.filter.HttpFilter;


import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class TransactionFilter
 */
public class TransactionFilter extends HttpFilter implements Filter {

	
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("事务已将开启");
		//获取连接
		 Connection connection = JDBCUtils.getConnection();
		try {
			//开启事务
			connection.setAutoCommit(false);
			//放行请求
			chain.doFilter(request, response);
			//提交事务
			connection.rollback();
		} catch (Exception e) {
			try {
				//出现异常，回滚事务
				connection.rollback();
				//重定向到错误页面
				response.sendRedirect(request.getContextPath()+"/pages/error/error.jsp");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			//关闭连接
			JDBCUtils.releaseConnection();
		}
	}		
	}





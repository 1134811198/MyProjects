package com.atguigu.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReqRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReqRegServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
	String password = request.getParameter("password");
	System.out.println(username);
	System.out.println(password);
	String contextPath = request.getContextPath();
	System.out.println(contextPath);
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.html");
	System.out.println(requestDispatcher);
	requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter writer = response.getWriter();
	//writer.write("good");
		response.sendRedirect("success.html");
	}

}

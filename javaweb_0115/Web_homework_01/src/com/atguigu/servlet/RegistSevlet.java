package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegistSevlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              Object username = request.getParameter("username");
              Object password = request.getParameter("password");
              System.out.println(username);
              System.out.println(password);
              if("admin".equals(username) && "123456".equals(password)) {
            	  response.sendRedirect("pages/regist_success.html");
              }else {
            	  RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/regist_error.html");
            	  requestDispatcher.forward(request, response);
            	  
              }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}

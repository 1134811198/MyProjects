package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		        // 获取用户名和密码
//				String username = request.getParameter("username");
//				String password = request.getParameter("password");
//				
//				//假设用户名和密码正确，将用户保存到session域中
//			    HttpSession session = request.getSession();
//			    session.setAttribute("user", username);
//			    session.setAttribute("password", password);
//				//重定向到首页
//				response.sendRedirect(request.getContextPath()+"/index.jsp");
				// 获取用户名和密码
				String username = request.getParameter("username");
				//假设用户名和密码正确，将用户保存到session域中
				HttpSession session = request.getSession();
				session.setAttribute("user", username);
				//重定向到首页
				response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

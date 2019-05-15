

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        //获取用户名和密码
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				//假设用户名和密码正确，创建两个Cookie对象保存用户名和密码
				Cookie cookie1=new Cookie("username", username);
				Cookie cookie2=new Cookie("password", password);
				//将两个Cookie的有效时间设置为7天
                 cookie1.setMaxAge(7*24*60*60);
                 cookie2.setMaxAge(7*24*60*60);
				//将两个Cookie对象发送给浏览器
                 response.addCookie(cookie1);
                 response.addCookie(cookie2);
				//重定向到登录成功页面
			     response.sendRedirect(request.getContextPath()+"/success.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

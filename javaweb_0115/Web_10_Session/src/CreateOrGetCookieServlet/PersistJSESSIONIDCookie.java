package CreateOrGetCookieServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersistJSESSIONIDCookie
 */
public class PersistJSESSIONIDCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersistJSESSIONIDCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取Cookie对象
				Cookie[] cookies = request.getCookies();
						//获取Cookie对象的名字
				if(cookies != null) {
					for (Cookie cookie : cookies) {
						String name = cookie.getName();
						if("JSESSIONID".equals(name)) {
							cookie.setMaxAge(60);
							response.addCookie(cookie);
						}
					}
				}					
							//持久化该Cookie对象
							
							//将Cookie对象发送给浏览器
						
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

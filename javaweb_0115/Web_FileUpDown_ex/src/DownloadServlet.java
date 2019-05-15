

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("resource")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取要下载的资源的真实路径
		ServletContext servletContext = getServletContext();
		String realPath = servletContext.getRealPath("/WEB-INF/download/rb.jpg");
		// 给要下载的文件起一个中文的名字
		String filename="热巴.jpg";
		// 判断使用的是否是火狐浏览器
		String header = request.getHeader("User-Agent");
		if(header.contains("Firefox")) {
			filename = "=?utf-8?b?" + new BASE64Encoder().encode(filename.getBytes()) + "?=";
		}else {
			//对于中文的文件名需要使用URL进行编码
			filename = URLEncoder.encode(filename, "UTF-8");
		}
		 // 1.创建一个输入流
		FileInputStream is = new FileInputStream(realPath);
		 // 2.设置两个响应头	
		// ①设置文件的类型
        // 获取要下载的文件的mime值
		String mimeType = servletContext.getMimeType(realPath);
		// ②告诉浏览器如何处理该文件
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		// 3.将流输出到浏览器
		ServletOutputStream os = response.getOutputStream();
		IOUtils.copy(is, os);
		// 4.关闭流
        is.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.atguigu.upload.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 处理文件上传的Servlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户名和照片
//		String username = request.getParameter("username");
//		String photo = request.getParameter("photo");
//		System.out.println(username);
//		System.out.println(photo);
		//1.创建工厂类实例
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//2.创建解析器类实例
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		//单个文件的大小限制为6KB
//		fileUpload.setFileSizeMax(6*1024);
		//fileUpload.setFileSizeMax(10*1024);
		//总文件的大小限制为18KB
		//fileUpload.setSizeMax(18*1024);
		//设置了上传文件的大小限制之后，如果上传过大的文件服务器将无响应，此时需要在Tomcat服务器的sever.xml文件的第一个
		//Connector标签中添加maxSwallowSize="-1"即可
		try {
			//3.解析请求得到FilterItem对象
			List<FileItem> fileItems = fileUpload.parseRequest(request);
			//4.遍历得到每一个FileItem对象
			for (FileItem fileItem : fileItems) {
				/*
				 * 七个核心方法：
				 * 	isFormField()：判断是否是一个普通表单项
				 * 	getString(String encoding)：获取普通表单项中用户输入的内容，该方法中可以传入一个字符集
				 * 	getFieldName()：获取表单项中的name属性值
				 * 
				 * 	getName()：获取文件名
				 * 	getContentType()：获取文件类型，是一个MIME值
				 * 	getSize()：获取文件的大小
				 * 	write(File file)：将文件写到服务器中的某个文件
				 * 	
				 */
				boolean flag = fileItem.isFormField();
				if(flag) {
					//是一个普通表单项
					//获取name属性值
					String fieldName = fileItem.getFieldName();
					//获取用户输入的内容
					String username = fileItem.getString("UTF-8");
					System.out.println("文本框中的name属性值为："+fieldName);
					System.out.println("文本框中用户输入的内容为："+username);
				}else {
					//是一个上传文件的表单项
					//获取文件名
					String name = fileItem.getName();
					//对于IE浏览器获取文件名包含盘符，所以需要将文件名之前的部分截取
					name = name.substring(name.lastIndexOf("\\")+1);
					//获取文件的类型
					String contentType = fileItem.getContentType();
					//获取文件的大小
					long size = fileItem.getSize();
					System.out.println("文件名是："+name);
					System.out.println("文件的类型是："+contentType);
					System.out.println("文件的大小是："+size+"个字节");
					//将文件上传到G盘的根目录
//					fileItem.write(new File("G:/"+name));
					//需求：将文件上传到服务器的upload目录中
					//获取ServletContext对象
					ServletContext servletContext = getServletContext();
					//获取服务器端upload目录的真实路径
					String realPath = servletContext.getRealPath("/upload");
					//判断服务器端的upload目录是否存在，如果不存在自动创建
					File file = new File(realPath);
					if(!file.exists()) {
						file.mkdirs();
					}
//					System.out.println(realPath);
					//使用UUID随机生成一个字符串作为文件的前缀
					String prefix = UUID.randomUUID().toString().replace("-", "");
					//上传文件到upload
					fileItem.write(new File(realPath+"/"+prefix+"_"+name));
				}
			}
			//重定向到上传成功的页面
			response.sendRedirect(request.getContextPath() + "/success.jsp");
		} catch (FileSizeLimitExceededException e) {
			// 设置一个错误信息并放到request域中
			request.setAttribute("msg", "单个文件的大小不能超过6KB!");
			// 转发到首页
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			e.printStackTrace();
		} catch (SizeLimitExceededException e) {
			// 设置一个错误信息并放到request域中
			request.setAttribute("msg", "总文件的大小不能超过18KB!");
			// 转发到首页
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}



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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UploadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
		//单个文件的大小限制为6KB
		 fileUpload.setFileSizeMax(100*1024);
		 try {
			List<FileItem> list = fileUpload.parseRequest(request);
			for (FileItem fileItem : list) {
				boolean flag = fileItem.isFormField();
				if(flag) {
					String fieldName = fileItem.getFieldName();
					String name = fileItem.getName();
					System.out.println("1"+fieldName);
					System.out.println("2"+name);
				}else {
					String fieldName = fileItem.getFieldName();
					String name = fileItem.getName();
					System.out.println("3"+fieldName);
					System.out.println("4"+name);
					name=name.substring(name.lastIndexOf("\\")+1);
					//需求：将文件上传到服务器的upload目录中
					ServletContext servletContext = getServletContext();
					String realPath = servletContext.getRealPath("/upload");
					File file=new File(realPath);
					if(!file.exists()) {
						file.mkdir();
					}
					System.out.println("5真实路径是："+realPath);
					String prefix = UUID.randomUUID().toString().replace("-", "");
					try {
						fileItem.write(new File(realPath+"/"+prefix+"_"+name));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
			response.sendRedirect(request.getContextPath()+"/success.jsp");
		} catch (FileUploadException e) {
			request.setAttribute("msg", "文件最大为6kb");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

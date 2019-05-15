package com.atguigu.springmvc.crud.handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.springmvc.crud.beans.Department;
import com.atguigu.springmvc.crud.beans.Employee;
import com.atguigu.springmvc.crud.dao.DepartmentDao;
import com.atguigu.springmvc.crud.dao.EmployeeDao;

@Controller
public class RestCrudHandler {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao ;
	
	/**
	 * SimpleMappingExceptionResolver
	 */
	@RequestMapping("/testSimpleMapping")
	public String testSimpleMappingExceptionResolver(@RequestParam("i")Integer i ) {
		
		Integer  result = 10 / i ; 
		
		return "success";
		
	}
	
	/**
	 *  DefaultHandlerExceptionResolver
	 */
	@RequestMapping(value = "/testDefaultException", method = RequestMethod.POST)
	public String testDefaultException() {
		return "success";
	}
	
	
	
	/**
	 * 上传文件
	 */
	@RequestMapping("/testFileUpload")
	public String testFileUpload(@RequestParam("desc")String desc ,
				@RequestParam("uploadFile")MultipartFile uploadFile,HttpSession session,Map<String,Object > map  )
				throws Exception{
		
		ServletContext sc = session.getServletContext();
		//获取上传文件夹的真实路径
		String realPath = sc.getRealPath("upload");
		//创建File对象，描述目标文件
		File targetFile  = new File(realPath+ File.separator+uploadFile.getOriginalFilename());
		/*//输入流
		InputStream in = uploadFile.getInputStream();
		//输出流
		OutputStream os = new FileOutputStream(targetFile);
		//写文件
		int i ; 
		while((i=in.read())!=-1) {
			os.write(i);
		}
		
		in.close();
		os.close();*/
		
		uploadFile.transferTo(targetFile);
		
		map.put("fileName", "upload"+File.separator+uploadFile.getOriginalFilename());
		
		return "success";
		
	}
	
	/**
	 * ResponseEntity
	 */
	@RequestMapping("/testResponseEntity")
	public  ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws Exception{
		byte [] file  = null ;
		ServletContext sc = session.getServletContext();
		InputStream in = sc.getResourceAsStream("file"+File.separator+"girl.jpg");
		
		file = new byte[in.available()];
		
		in.read(file);
		
		//构造ResponseEntity
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachement;filename=girl.jpg");
		
		HttpStatus statusCode= HttpStatus.OK;  //200
		
		ResponseEntity<byte [] > re = new ResponseEntity<byte[]>(file, headers, statusCode);
		
		return re ;
	}
	
	/**
	 * HttpEntity
	 */
	@RequestMapping("/testHttpEntity")
	public String testHttpEntity(HttpEntity<String> entity ) {
		System.out.println(entity.getHeaders().get("Accept-Language"));
		
		return "success";
	}
	/**
	 * @RequestBody
	 */
	@RequestMapping("/testRequestBody")
	public String testRequestBody(@RequestBody String body ) {
		System.out.println("body:" + body );
		
		return "success";
	}
	
	/**
	 * 处理Json
	 */
	@ResponseBody
	@RequestMapping("/testJson")
	public Collection<Employee> testJson() {
		Collection<Employee> emps = employeeDao.getAll();
		//javaWEB:  String jsonStr = new Gson().toJson(emps);
		//          response.getWriter().println(jsonStr);
		return emps ;
	}
	
	
	/**
	 * 修改员工
	 */
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String editEmp(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	/**
	 * 去往修改页面
	 */
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String  toEditPage(@PathVariable("id")Integer id,Map<String,Object> map ) {
		//查询要修改的员工, 页面中要回显的数据
		Employee employee = employeeDao.get(id);
		map.put("employee", employee);
		
		//查询部门数据
		Collection<Department> depts = 
				departmentDao.getDepartments();
		map.put("depts", depts);
		
		//构造生成性别单选框的数据
		Map<String,String> genders = new HashMap<>();
		genders.put("1", "男");
		genders.put("0", "女");
		map.put("genders", genders);
		
		return "edit";
		
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("id")Integer id ) {
		employeeDao.delete(id);
		
		return "redirect:/emps";
	}
	
	
	/**
	 * 添加
	 */
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String addEmp(Employee employee) {
		//添加员工
		employeeDao.save(employee);
		//回到列表
		return "redirect:/emps";
	}
	
	
	/**
	 * 去往添加页面:
	 * 1. 因为添加页面中需要用到所有的部门数据， 要将部门数据查询出来，转发到添加页面
	 * 2. 需要构造生成性别单选框的数据
	 * 3. 需要指定用于表单回显的数据
	 */
	
	@RequestMapping(value = "/emp",method=RequestMethod.GET)
	public String toAddPage(Map<String,Object> map ) {
		//查询部门数据
		Collection<Department> depts = 
				departmentDao.getDepartments();
		map.put("depts", depts);
		
		//构造生成性别单选框的数据
		Map<String,String> genders = new HashMap<>();
		genders.put("1", "男");
		genders.put("0", "女");
		
		map.put("genders", genders);
		
		//解决页面回显数据的问题
		Employee employee = new Employee();
		map.put("employee", employee);
		
		return "edit";
	}
	
	/**
	 * 查询所有的员工信息， 列表展示
	 */
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public String  listAllEmps(Map<String,Object> map ) {
		//查询所有的员工信息
		Collection<Employee> emps = employeeDao.getAll();
		map.put("emps", emps);
		
		return "list";
	}
}

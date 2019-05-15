package com.atguigu.springmvc.crud.handler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
import com.sun.jmx.interceptor.DefaultMBeanServerInterceptor;

@Controller
public class RestCrudHandler {
	
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	/*
	 * testSimpleMappingExceptionResolver
	 */
	@RequestMapping("/testSimpleMappingExceptionResolver")
	public String testSimpleMappingExceptionResolver(@RequestParam("i")Integer i) {
		Integer result=10/i;
		return "success";
	}
	/*
	 * testFileUpload
	 */
	@RequestMapping("/testFileUpload")
	public String testFileUpload(@RequestParam("desc")String desc ,
				@RequestParam("uploadFile")MultipartFile uploadFile,HttpSession session,Map<String,Object > map  )
				throws Exception{
		
		ServletContext sc = session.getServletContext();
		//获取上传文件夹的真实路径
		String realPath = sc.getRealPath("upload");
		System.out.println(realPath);
		//创建File对象，描述目标文件
		File targetFile  = new File(realPath+ File.separator+uploadFile.getOriginalFilename());

		uploadFile.transferTo(targetFile);
		
		map.put("fileName", "upload"+File.separator+uploadFile.getOriginalFilename());
		
		return "success";
		
	}

	/*
	 * testResponseEntity
	 */
	@RequestMapping("/testResponseEntity")
	public ResponseEntity<byte []> testResponseEntity(HttpSession session) throws Exception {
		byte[] file=null;
		
		ServletContext servletContext = session.getServletContext();
		InputStream inputStream = servletContext.getResourceAsStream("picture"+File.separator+"shanshan.jpg");
		int i = inputStream.available();
		System.out.println(i);
		file=new byte[i];
		inputStream.read(file);
		//构造ResponseEntity
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=shanshan.jpg");
		HttpStatus statusCode=HttpStatus.OK;
		ResponseEntity<byte[]> responseEntity=new ResponseEntity<byte[]>(file, headers, statusCode);
		return responseEntity;
		
	}
	/*
	 * testHttpEntity
	 */
	@RequestMapping(value="/testHttpEntity",method=RequestMethod.GET)
	public String testHttpEntity(HttpEntity<String> httpEntity) {
		System.out.println(httpEntity.getHeaders().get("Accept-language"));
		return "success";
		
	}
	/*
	 * TestRequestBody
	 */
	
	@RequestMapping(value="/testRequestBody", method=RequestMethod.POST)
	public String testRequestBody(@RequestBody String body) {
		System.out.println("body"+body);
		return "success";
	}
	/*
	 * TestJson
	 */
	@ResponseBody
	@RequestMapping(value="/testJson")
	public Collection<Employee>  testJson() {
		Collection<Employee> emps = employeeDao.getAll();
		return emps;
		
	}
	/*
	 * 修改员工信息
	 */
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String edit(Employee employee) {
		employeeDao.save(employee);
		
		return "redirect:/emps";
		
	}
	/*
	 *去往编辑页面
	 */
	@RequestMapping(value="/emp/{id}" ,method=RequestMethod.GET)
	public String editPage(@PathVariable("id")Integer id,Map<String,Object> map) {
		Employee employee = employeeDao.get(id);
		map.put("employee", employee);
		
		Collection<Department> depts = departmentDao.getDepartments();
		map.put("depts", depts);
		
		Map<String,String> genders=new HashMap<>();
		genders.put("0", "女");
		genders.put("1", "男");
		map.put("genders", genders);
		
		return "editORadd";
		
	}
	/*
	 * 删除员工
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("id")Integer id) {
		
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	/*
	 * 添加员工
	 */
	@RequestMapping(value="/emp", method=RequestMethod.POST)	
	public String ADD(Employee employee) {
		employeeDao.save(employee);
		return "redirect:emps";
	}

	@RequestMapping(value="/emp" ,method=RequestMethod.GET)
	public String toADDPage(Map<String ,Object> map) {
		
		
		Collection<Department> depts = departmentDao.getDepartments();
		map.put("depts", depts);
		
		Map<String,String> genders = new HashMap<>();
		genders.put("0", "女");
		genders.put("1", "男");
		map.put("genders", genders);
		
		
		Employee employee = new Employee();
		map.put("employee", employee);
		
		return "editORadd";
		
	}
	
	/**
	 * 查询所有的员工信息， 列表展示
	 */
	@RequestMapping(value="/emps",method=RequestMethod.GET)
  public String showAllEmps(Map<String,Object> map){
		Collection<Employee> emps = employeeDao.getAll();
		map.put("emps", emps);
		
	return "list";
	  
  }
}

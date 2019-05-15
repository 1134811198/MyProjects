package testAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.controllor.EmployeeController;
import com.atguigu.spring.dao.EmployeeDao;
import com.atguigu.spring.dao.EmployeeDaoImpl;
import com.atguigu.spring.service.EmployeeService;

public class TestAnnotation {
	
	
   public static void main(String[] args) {
	ApplicationContext ctx=
	     new ClassPathXmlApplicationContext("annotation.xml");
	EmployeeController employeeController = ctx.getBean("employeeController",EmployeeController.class);
	System.out.println("employeeController"+employeeController);
	EmployeeService employeeService = ctx.getBean("employeeService",EmployeeService.class);
	System.out.println("employeeService"+employeeService);
	EmployeeDao employeeDao = ctx.getBean("employeeDaoImpl",EmployeeDao.class);
	System.out.println("employeeDao"+employeeDao);
	
	employeeController.regist();
	   
			
   }
}

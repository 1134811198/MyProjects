package com.atguigu.SpringIOC.beans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.SpringIOC.Controller.Student;
import com.atguigu.SpringIOC.Dao.StudentDao;
import com.atguigu.SpringIOC.Service.StudentService;

public class TestIOC {
/*
 *  实验1：通过IOC容器创建对象，并为属性赋值★
 */
	/*
	 * 实验2：根据bean的类型从IOC容器中获取bean的实例★
	 */
	@Test
	public void test() {
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("SpringIOC.xml");
		Employee employee = ctx.getBean("employee",Employee.class);
		System.out.println(employee);
	}
	/*
	 * 实验6：引用其他bean★
	 */
	@Test
	public void test02() {
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("SpringIOC.xml");
		Employee employee = ctx.getBean("employee",Employee.class);
		System.out.println(employee);
	}
/*
 * 实验20：引用外部属性文件★
 */
    @Test
    public void test03() {
    	ApplicationContext ctx=
				new ClassPathXmlApplicationContext("SpringIOC.xml");
		Employee employee = ctx.getBean("employee",Employee.class);
		System.out.println(employee);
    }
    /*
     * 实验19：测试bean的作用域，分别创建单实例和多实例的bean★
     */
    @Test
    public void test04() {
    	ApplicationContext ctx=
				new ClassPathXmlApplicationContext("SpringIOCScope.xml");
		Employee employee = ctx.getBean("employee",Employee.class);
		System.out.println(employee);
		Employee employee2 = ctx.getBean("employee",Employee.class);
		System.out.println(employee2);
		System.out.println(employee==employee2);
    }
    /*
     * 实验32：通过注解分别创建Dao、Service、Controller★
     * 实验35：使用@Autowired注解实现根据类型实现自动装配★
     */
    @Test
    public void test05() {
    	ApplicationContext ctx=
				new ClassPathXmlApplicationContext("SpringIOCAnnotation.xml");
    	Student student = ctx.getBean("student",Student.class);
    	StudentService studentService = ctx.getBean("studentServiceImpl",StudentService.class);
    	StudentDao studentDao = ctx.getBean("studentDaoImpl",StudentDao.class);
    	
    	System.out.println(student);
    	student.goToSchool();
    	
    }
/*
 * 实验37：如果根据成员变量名作为id还是找不到bean，可以使用@Qualifier注解明确指定目标bean的id★
 */

}

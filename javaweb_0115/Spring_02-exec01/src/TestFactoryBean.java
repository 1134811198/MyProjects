

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {

	@Test
	public void test() {
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("FactoryBean.xml");
		Employee employee = ctx.getBean("employee",Employee.class);
		System.out.println(employee);
	}

}

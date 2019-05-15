
package com.atguigu.i18n.test;



import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

import org.junit.Test;



public class i18NTest {

	@Test
	public void testLocale() {
		// 获取系统默认的语言及国家的信息
		Locale default1 = Locale.getDefault();
		System.out.println(default1);
		// 获取中国的语言及国家的信息
		Locale china = Locale.CHINA;
		System.out.println(china);
		// 获取美国的语言及国家的信息
	    Locale us = Locale.US;
	    System.out.println(us);
	}
	@Test
	public void testResourceBundle() {
		// 获取中国的语言及国家的信息
		Locale china = Locale.CHINA;
		System.out.println(china);
		// 获取美国的语言及国家的信息
	    Locale us = Locale.US;
	    System.out.println(us);
		//获取国际化资源文件中的内容
	    ResourceBundle bundle = ResourceBundle.getBundle("i18n", china);
	    String login = bundle.getString("Login");
		System.out.println("1111"+login);
	}


}

package com.atguigu.ss.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyServletContextListener implements ServletContextListener {
	
	/**
	 * 销毁方法
	 */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }
    /**
     * 初始化方法： 监听到ServletContext对象创建时，会执行该方法. 
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	//sce.getServletContext().getInitParameter(name)
    	
    	//创建SpringIOC容器对象
    	ApplicationContext ctx = 
    			new ClassPathXmlApplicationContext("applicationContext.xml");
    	//绑定到ServletContext域对象中
    	
    	ServletContext sc = sce.getServletContext();
    	sc.setAttribute("applicationContext", ctx);
    	
    }
	
}

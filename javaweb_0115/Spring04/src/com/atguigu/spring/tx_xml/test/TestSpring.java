package com.atguigu.spring.tx_xml.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.tx_xml.dao.BookShopDao;
import com.atguigu.spring.tx_xml.service.BookShopService;
import com.atguigu.spring.tx_xml.service.Cashier;


public class TestSpring {
	
	private BookShopDao bookShopDao;
	private BookShopService bookShopService;
	private Cashier cashier ; 

	@Before
	public void init() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-tx_xml.xml");
		
		bookShopDao = ctx.getBean("bookShopDaoImpl",BookShopDao.class);
		
		bookShopService = ctx.getBean("bookShopServiceImpl",BookShopService.class);
		
		cashier = ctx.getBean("cashierImpl",Cashier.class);
	}
	
	@Test
	public void test() {
		bookShopService.buyBook("Tom", "1002");
	}
	
	@Test
	public void testCheckOut() {
		List<String> isbns = new ArrayList<>();
		isbns.add("1001");
		isbns.add("1002");
		cashier.checkOut("Tom", isbns);
	}

}

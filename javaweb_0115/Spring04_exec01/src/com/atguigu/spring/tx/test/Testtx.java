package com.atguigu.spring.tx.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.tx.Service.BookshopService;
import com.atguigu.spring.tx.Service.Cashier;
import com.atguigu.spring.tx.dao.BookshopDao;



public class Testtx {

	private BookshopDao bookshopDao;
	private BookshopService bookshopService;
	private Cashier cashier;
	
	@Before
	public void testBefore() {
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("Jdbctx.xml");
	
	  
	    bookshopDao = ctx.getBean("bookshopDaoImpl",BookshopDao.class);
	  System.out.println(bookshopDao);
	  
	  bookshopService = ctx.getBean("bookshopServiceImpl",BookshopService.class);
	  System.out.println(bookshopService);
	  
	   cashier = ctx.getBean("cashierImpl",Cashier.class);
	   System.out.println(cashier);
	  
	  
	}
	@Test
	public void testtx() {
		
		bookshopService.buyBook("Tom", "1001");
		bookshopService.buyBook("Tom","1001");
	}
	@Test
	public void textCheckout() {
		List<String> isbns=new ArrayList();
		isbns.add("1001");
		isbns.add("1002");
		cashier.Checkout("Tom", isbns);
	}
}

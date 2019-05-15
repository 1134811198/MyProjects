package com.atguigu.SpringAop.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.SpringAop.Dao.BookshopDao;
import com.atguigu.SpringAop.Service.BookshopService;
import com.atguigu.SpringAop.Service.Cashier;

public class TestTransactional {
	BookshopDao bookshopDao;
	BookshopService bookshopService;
	Cashier cashier;
	@Before
	public void init() {
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("SpringAop.xml");
		bookshopDao = 
				ctx.getBean("bookshopDaoImpl",BookshopDao.class);
		bookshopService = 
				ctx.getBean("bookshopServiceImpl",BookshopService.class);
		cashier = ctx.getBean("cashierImpl",Cashier.class);
	}
/*
 * [5]加上事务注解，重新执行[4],关注数据库数据的变化
 */
	@Test
	public void test() {

		bookshopService.buyBook("Tom", "1001");
	}
/*
 * [7]加上事务注解,重新执行[6],关注数据库数据的变化
 */
	@Test
	public void test07() {
		bookshopService.buyBook("Tom", "1001");
		bookshopService.buyBook("Tom", "1001");
	}
/*
 * [8]演示事务的传播行为
 */
	@Test
	public void test08() {
		List<String> isbns=new ArrayList<>();
		isbns.add("1001");
		isbns.add("1001");
		isbns.add("1001");
		cashier.pay("Tom", isbns);
	}
}

package com.atguigu.SpringAop.Test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atguigu.SpringAop.Exception.BalanceException;
import com.atguigu.SpringAop.Exception.StockException;



public class TestSpring {
	JdbcTemplate jdbcTemplate;
	@Before
	public void init() {
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("SpringAop.xml");
		jdbcTemplate = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
		System.out.println(jdbcTemplate);
	}
	/*
	 * [1]根据isbn的值查询书的价格 
	 */
	@Test
	public void test01() {
		
		String sql="select price from book where isbn = ?";
		Integer price = jdbcTemplate.queryForObject(sql, Integer.class, 1001);
		System.out.println(price);
		
	}
	/*
	 * [2]根据isbn的值减少书的库存，假设每次都只买1本书
	 */
	@Test
	public void test02() {
		String sql="select stock from book_stock where isbn = ?";
		Integer stock = jdbcTemplate.queryForObject(sql, Integer.class, 1001);
		System.out.println(stock);
		if(stock == 0) {
			throw new StockException("库存不足");
		}
		
		sql="update book_stock set stock = stock - 1 where isbn = ?";
		jdbcTemplate.update(sql, 1001);
	}
	/*
	 * [3]根据用户名减少用户账户中的余额，减少的额度就是书的价格
	 */
     @Test
     public void test03() {
    	 String sql="select balance from account where username= ?";
    	 Integer balance = jdbcTemplate.queryForObject(sql, Integer.class, "Tom");
    	 System.out.println(balance);
    	 sql="select price from book where isbn = ?";
    	 Integer price = jdbcTemplate.queryForObject(sql, Integer.class, 1001);
    	 System.out.println(price);
    	 if(balance<price) {
    		 throw new BalanceException("余额不足");
    	 }
    	 sql="update account set balance = balance - ? where username = ? ";
    	 jdbcTemplate.update(sql, price,"Tom");
     }
     /*
      * [4]模拟买一本书，库存足够，余额不足， 关注数据库数据的变化
      */
     @Test
     public void test04() {
 		String sql="select stock from book_stock where isbn = ?";
 		Integer stock = jdbcTemplate.queryForObject(sql, Integer.class, 1001);
 		System.out.println(stock);
 		if(stock == 0) {
 			throw new StockException("库存不足");
 		}
 		
 		sql="update book_stock set stock = stock - 1 where isbn = ?";
 		jdbcTemplate.update(sql, 1001);
 		
 		
		String sql2 = "select balance from account where username= ?";
		Integer balance = jdbcTemplate.queryForObject(sql2, Integer.class, "Tom");
		System.out.println(balance);
		sql2 = "select price from book where isbn = ?";
		Integer price = jdbcTemplate.queryForObject(sql2, Integer.class, 1001);
		System.out.println(price);
		if (balance < price) {
			throw new BalanceException("余额不足");
		}
		sql2 = "update account set balance = balance - ? where username = ? ";
		jdbcTemplate.update(sql2, price, "Tom");
	}
 	/*
 	 * [6]模拟结账行为(同时买多本书),库存足够，余额只够买其中的一本，关注是数据库数据的变化
 	 */
     @Test
     public void test06() {
  		String sql="select stock from book_stock where isbn = ?";
  		Integer stock = jdbcTemplate.queryForObject(sql, Integer.class, 1001);
  		System.out.println("stock:"+stock);
  		if(stock == 0) {
  			throw new StockException("库存不足");
  		}
  		
  		sql="update book_stock set stock = stock - 1 where isbn = ?";
  		jdbcTemplate.update(sql, 1001);
 	
 		String sql2 = "select balance from account where username= ?";
 		Integer balance = jdbcTemplate.queryForObject(sql2, Integer.class, "Tom");
 		System.out.println("balance:"+balance);
 		sql2 = "select price from book where isbn = ?";
 		Integer price = jdbcTemplate.queryForObject(sql2, Integer.class, 1001);
 		System.out.println("price:"+price);
 		if (balance < price) {
 			throw new BalanceException("余额不足");
 		}
 		sql2 = "update account set balance = balance - ? where username = ? ";
 		jdbcTemplate.update(sql2, price, "Tom");
 		
 		System.out.println("============================");
  		String sql3="select stock from book_stock where isbn = ?";
  		Integer stock2 = jdbcTemplate.queryForObject(sql3, Integer.class, 1001);
  		System.out.println(stock2);
  		if(stock2 == 0) {
  			throw new StockException("库存不足");
  		}
  		
  		sql3="update book_stock set stock = stock - 1 where isbn = ?";
  		jdbcTemplate.update(sql, 1001);
 	
 		String sql4 = "select balance from account where username= ?";
 		Integer balance2 = jdbcTemplate.queryForObject(sql4, Integer.class, "Tom");
 		System.out.println("balance2:"+balance2);
 		sql4 = "select price from book where isbn = ?";
 		Integer price2 = jdbcTemplate.queryForObject(sql4, Integer.class, 1001);
 		System.out.println("price2:"+price2);
 		if (balance2 < price2) {
 			throw new BalanceException("余额不足");
 		}
 		sql4 = "update account set balance = balance - ? where username = ? ";
 		jdbcTemplate.update(sql4, price2, "Tom");

     }
}

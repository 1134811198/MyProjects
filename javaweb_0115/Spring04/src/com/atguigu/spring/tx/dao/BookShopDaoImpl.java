package com.atguigu.spring.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.atguigu.spring.tx.exception.BookStockException;
import com.atguigu.spring.tx.exception.UserAccountException;

@Repository
public class BookShopDaoImpl  implements BookShopDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate ; 

	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql ="select price from book where isbn = ? ";
		return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
	}

	@Override
	public void updateBookStock(String isbn) {
		//1. 判断库存是否足够 
		String sql="select stock from book_stock where isbn = ?";
		
		Integer stock = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		
		if(stock <=0) {
			//库存不足
			throw new BookStockException("库存不足啦....");
		}
		
		//2. 更新库存
		sql="update book_stock set stock = stock - 1 where isbn = ? ";
		
		jdbcTemplate.update(sql, isbn);
		
	}

	@Override
	public void updateUserAccount(String username, Integer price) {
		//1. 查询用户的余额是否足够
		String sql ="select balance from account where username = ? ";
		
		Integer balance = jdbcTemplate.queryForObject(sql, Integer.class,username);
		
		if(balance < price) {
			throw new UserAccountException("余额不足啦....");
		}
		
		//更新余额
		sql= "update account set balance = balance - ? where username = ?";
		jdbcTemplate.update(sql, price,username);
	}
	
}

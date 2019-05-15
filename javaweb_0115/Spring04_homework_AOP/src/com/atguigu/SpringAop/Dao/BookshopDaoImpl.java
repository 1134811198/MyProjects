package com.atguigu.SpringAop.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.atguigu.SpringAop.Exception.BalanceException;
import com.atguigu.SpringAop.Exception.StockException;

@Repository

public class BookshopDaoImpl implements BookshopDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void updateStock(String isbn) {
		String sql="select stock from book_stock where isbn = ?";
		Integer stock = jdbcTemplate.queryForObject(sql, Integer.class, 1001);
		System.out.println("original stock==="+stock);
		if(stock == 0) {
			throw new StockException("库存不足");
		}
		
		sql="update book_stock set stock = stock - 1 where isbn = ?";
		jdbcTemplate.update(sql, 1001);
		System.out.println("更新stock成功");
	}

	@Override
	public void updateAccount(String lastName, Integer price) {
		String sql = "select balance from account where username= ?";
		Integer balance = jdbcTemplate.queryForObject(sql, Integer.class, "Tom");
		System.out.println("original balance==="+balance);
		if (balance < price) {
			throw new BalanceException("余额不足");
		}
		sql = "update account set balance = balance - ? where username = ? ";
		jdbcTemplate.update(sql, price, "Tom");
		System.out.println("更新account成功");
	}

	@Override
	public Integer findPriceByIsbn(String isbn) {
		String sql="select price from book where isbn = ?";
		Integer price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		System.out.println("price==="+price);
		return price;
	}

}

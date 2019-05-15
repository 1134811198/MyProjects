package com.atguigu.spring.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.spring.tx.exception.BookshopStockException;
import com.atguigu.spring.tx.exception.UserAccountExcception;


@Repository
public class BookshopDaoImpl implements BookshopDao{
    @Autowired
	JdbcTemplate jdbcTemplate;
    
	@Override
	public Integer findBookPriceByIsbn(String isbn) {
		
		String sql="select price from book where isbn = ?";
		Integer price = jdbcTemplate.queryForObject(sql, Integer.class,isbn);
		
		return price;
	}

	@Override
	public void updateBookStock(String isbn) {
		String sql="select stock from book_stock where isbn= ?";
		Integer stock = jdbcTemplate.queryForObject(sql, Integer.class,isbn);
		if(stock<=0) {
			throw new BookshopStockException("库存不足");
		}
		 sql="update  book_stock set stock=stock-1 where isbn= ?";
		jdbcTemplate.update(sql, isbn);
	}

	@Override
	public void updateUserAccount(Integer price, String username) {
		String sql="select balance from account where username = ?";
		
		Integer balance = jdbcTemplate.queryForObject(sql, Integer.class,username);
		if(balance<price) {
			throw new UserAccountExcception("用户余额不足");
		}
		
		sql="update account set balance = balance - ? where username= ?";
		jdbcTemplate.update(sql, price,username);
		
        
	}

}

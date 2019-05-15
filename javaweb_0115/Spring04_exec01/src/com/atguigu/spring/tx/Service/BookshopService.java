package com.atguigu.spring.tx.Service;

import org.springframework.stereotype.Service;


public interface BookshopService {

	/*
	 * 买书
	 */
	public void buyBook(String username,String isbn);
}

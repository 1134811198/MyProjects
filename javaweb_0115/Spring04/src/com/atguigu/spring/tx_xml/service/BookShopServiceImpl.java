package com.atguigu.spring.tx_xml.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.spring.tx_xml.dao.BookShopDao;

@Service
public class BookShopServiceImpl  implements BookShopService{
	
	@Autowired
	private BookShopDao bookShopDao; 
	
	
	public void buyBook(String username, String isbn) {
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//1. 先查询书的价格
		Integer price = bookShopDao.findBookPriceByIsbn(isbn);
		//2. 改库存
		bookShopDao.updateBookStock(isbn);
		
		//3. 改余额
		bookShopDao.updateUserAccount(username, price);
	}
}

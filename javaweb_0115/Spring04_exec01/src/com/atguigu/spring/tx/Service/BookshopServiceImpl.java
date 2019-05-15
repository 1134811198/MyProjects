package com.atguigu.spring.tx.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.spring.tx.dao.BookshopDao;
@Service
public class BookshopServiceImpl implements BookshopService{

	@Autowired
	BookshopDao bookshopDao;
	@Transactional(propagation=Propagation.REQUIRES_NEW,
			       isolation=Isolation.DEFAULT,
			       readOnly=true)
	@Override
	public void buyBook(String username, String isbn) {

		Integer price = bookshopDao.findBookPriceByIsbn(isbn);
		bookshopDao.updateBookStock(isbn);
		bookshopDao.updateUserAccount(price, username);
		
	}

}

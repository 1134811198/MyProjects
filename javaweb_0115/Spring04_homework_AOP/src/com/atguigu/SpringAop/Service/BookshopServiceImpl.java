package com.atguigu.SpringAop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.SpringAop.Dao.BookshopDao;
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class BookshopServiceImpl implements BookshopService{
    @Autowired
	BookshopDao bookshopDao;
	@Override
	public void buyBook(String lastName, String isbn) {
		Integer price = bookshopDao.findPriceByIsbn(isbn);
		bookshopDao.updateStock(isbn);
		bookshopDao.updateAccount(lastName, price);
	}
	


}

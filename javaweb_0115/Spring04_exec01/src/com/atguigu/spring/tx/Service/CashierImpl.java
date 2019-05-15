package com.atguigu.spring.tx.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class CashierImpl implements Cashier{
    @Autowired
	BookshopService bookshopService;
	@Override
	public void Checkout(String username, List<String> isbns) {
		for (String isbn : isbns) {
			
			bookshopService.buyBook(username, isbn);
		}
	}

}

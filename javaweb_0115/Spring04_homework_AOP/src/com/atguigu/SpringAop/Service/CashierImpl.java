package com.atguigu.SpringAop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




@Service
public class CashierImpl implements Cashier{
    @Autowired
	BookshopService bookshopService;

    @Transactional
	@Override
	public void pay(String lastName, List<String> isbns) {
		for (String isbn : isbns) {
			
			bookshopService.buyBook(lastName, isbn);
		}
	}


}

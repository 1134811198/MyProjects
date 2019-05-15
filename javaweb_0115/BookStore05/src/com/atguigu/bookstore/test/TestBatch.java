package com.atguigu.bookstore.test;

import org.junit.Test;

import com.atguigu.bookstore.dao.BookDao;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;

public class TestBatch {

	@Test
	public void test() {
		BookDao bookDao=new BookDaoImpl();
		Object [][] params=new Object [3][];
		//update books set sales = ? , stock = ? where id = ?
		params[0]=new Object[] {100,100,5};
		params[1]=new Object[] {200,200,6};
		params[2]=new Object[] {300,300,7};
		bookDao.batchUpdateSalesAndStock(params);
	}
}

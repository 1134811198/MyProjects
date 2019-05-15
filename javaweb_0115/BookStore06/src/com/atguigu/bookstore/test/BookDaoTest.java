package com.atguigu.bookstore.test;

import java.util.List;

import org.junit.Test;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Page;
import com.atguigu.bookstore.dao.BookDao;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;

public class BookDaoTest {

	BookDao bookDao = new BookDaoImpl();

	@Test
	void testGetPageBooksByPrice() {
		// 设置用户输入的页码
		int pageNo = 1;
		// 创建Page对象
		Page<Book> page = new Page<>();
		// 将页码设置到page对象中
		page.setPageNo(pageNo);

		// 调用bookDao中分页的方法
		Page<Book> pageBooks = bookDao.getPageBooksByPrice(page, 10.00, 30.00);
		System.out.println("当前页是：" + pageBooks.getPageNo());
		System.out.println("总页数是：" + pageBooks.getTotalPageNo());
		System.out.println("总记录数是：" + pageBooks.getTotalRecord());
		System.out.println("当前页中的图书有：");
		List<Book> list = pageBooks.getList();
		for (Book book : list) {
			System.out.println(book);
		}
	}

	@Test
	void testGetPageBooks() {
		// 设置用户输入的页码
		int pageNo = 1;
		// 创建Page对象
		Page<Book> page = new Page<>();
		// 将页码设置到page对象中
		page.setPageNo(pageNo);

		// 调用bookDao中分页的方法
		Page<Book> pageBooks = bookDao.getPageBooks(page);
		System.out.println("当前页是：" + pageBooks.getPageNo());
		System.out.println("总页数是：" + pageBooks.getTotalPageNo());
		System.out.println("总记录数是：" + pageBooks.getTotalRecord());
		System.out.println("当前页中的图书有：");
		List<Book> list = pageBooks.getList();
		for (Book book : list) {
			System.out.println(book);
		}
	}

	@Test
	void testUpdateBookById() {
		Book book = new Book(42, "时间简史第二季", "霍小金", 888.88, 10000, 1);
		bookDao.updateBookById(book);
	}

	@Test
	void testGetBookById() {
		Book bookById = bookDao.getBookById("1");
		System.out.println(bookById);
	}

	@Test
	void testDeleteBookById() {
		bookDao.deleteBookById("41");
	}

	@Test
	void testGetBooks() {
		List<Book> books = bookDao.getBooks();
		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Test
	void testSaveBook() {
		Book book = new Book(null, "三国演义", "罗贯中", 35.75, 100, 100);
		bookDao.saveBook(book);
	}
	
	@Test
	void testBatchUpdateSalesAndStock() {
		Object[][] params = new Object[4][];
		//update books set sales = ? , stock = ? where id = ?
		params[0] = new Object[] {100,100,1};
		params[1] = new Object[] {200,200,2};
		params[2] = new Object[] {300,300,3};
		params[3] = new Object[] {400,400,4};
		bookDao.batchUpdateSalesAndStock(params);
	}
}

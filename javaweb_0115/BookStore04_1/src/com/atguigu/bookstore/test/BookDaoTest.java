package com.atguigu.bookstore.test;

import java.util.List;

import org.junit.Test;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.dao.BookDao;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;

public class BookDaoTest {

	BookDao bookDao = new BookDaoImpl();
	
	@Test
	public void testUpdateBookById() {
		Book book = new Book(38, "时间简史第二季", "霍小金", 888.88, 10000, 1);
		bookDao.updateBookById(book);
	}
	
	@Test
	public void testGetBookById() {
		Book bookById = bookDao.getBookById("23");
		System.out.println(bookById);
	}
	
	@Test
	public void testDeleteBookById() {
		bookDao.deleteBookById("40");
	}
	
	@Test
	public void testGetBooks() {
		List<Book> books = bookDao.getBooks();
		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Test
	public void testSaveBook() {
		Book book = new Book(null, "三国演义", "罗贯中", 35.75, 100, 100);
		bookDao.saveBook(book);
	}
}

package com.atguigu.bookstore.service.impl;

import java.util.List;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.dao.BookDao;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;
import com.atguigu.bookstore.service.BookService;

public class BookServiceImpl implements BookService {

	BookDao bookDao=new BookDaoImpl();
	@Override
	public List<Book> getBooks() {
		List<Book> books = bookDao.getBooks();
		return books;
	}

	@Override
	public void saveBook(Book book) {
		bookDao.saveBook(book);
		
		
	}

	@Override
	public void deleteBookById(String bookId) {
		bookDao.deleteBookById(bookId);
		
	}

	@Override
	public Book getBookById(String bookId) {
		Book book = bookDao.getBookById(bookId);
		return book;
	}

	@Override
	public void updateBookById(Book book) {
		bookDao.updateBookById(book);
		
	}

	

}

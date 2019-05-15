package com.atguigu.bookstore.service;

import java.util.List;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Page;

public interface BookService {

	/**
	 * 获取所有图书的方法
	 * 
	 * @return
	 */
	List<Book> getBooks();

	/**
	 * 保存图书的方法
	 * 
	 * @param book
	 */
	void saveBook(Book book);

	/**
	 * 删除图书的方法
	 * 
	 * @param bookId
	 */
	void deleteBookById(String bookId);

	/**
	 * 获取图书的方法
	 * 
	 * @param bookId
	 * @return
	 */
	Book getBookById(String bookId);

	/**
	 * 更新图书的方法
	 * 
	 * @param book
	 */
	void updateBookById(Book book);

	/**
	 * 获取带分页图书信息的方法
	 * 
	 * @param pageNo
	 * @return
	 */
	Page<Book> getPageBooks(String pageNo);

	/**
	 * 获取带分页图书信息的方法
	 * 
	 * @param pageNo
	 * @return
	 */
	Page<Book> getPageBooksByPrice(String pageNo, String minPrice, String maxPrice);
}

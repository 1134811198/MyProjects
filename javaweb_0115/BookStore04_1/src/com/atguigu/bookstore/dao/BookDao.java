package com.atguigu.bookstore.dao;

import java.util.List;

import com.atguigu.bookstore.beans.Book;

public interface BookDao {

	/**
	 * 从数据库中查询出所有的图书
	 * 
	 * @return
	 */
	List<Book> getBooks();

	/**
	 * 向数据库中插入一本图书
	 * 
	 * @param book
	 */
	void saveBook(Book book);

	/**
	 * 根据图书的id从数据库中删除一本图书
	 * 
	 * @param bookId
	 */
	void deleteBookById(String bookId);

	/**
	 * 根据图书的id从数据库中查询出该图书信息
	 * 
	 * @param bookId
	 * @return
	 */
	Book getBookById(String bookId);

	/**
	 * 根据图书的id更新图书信息
	 * 
	 * @param book
	 */
	void updateBookById(Book book);
}

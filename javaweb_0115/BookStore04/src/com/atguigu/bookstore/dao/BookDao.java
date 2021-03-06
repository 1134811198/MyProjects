package com.atguigu.bookstore.dao;

import java.util.List;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Page;

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
	/**
	 * 获取带分页的图书信息
	 * 
	 * @param page
	 *            只包含页码属性的page对象
	 * @return 返回的page对象是包含了所有属性的page对象
	 */
	Page<Book> getPageBooks(Page<Book> page);

	/**
	 * 获取带价格范围和分页的图书信息
	 * 
	 * @param page
	 *            只包含页码属性的page对象
	 * @return 返回的page对象是包含了所有属性的page对象
	 */
	Page<Book> getPageBooksByPrice(Page<Book> page, double minPrice, double maxPrice);

}

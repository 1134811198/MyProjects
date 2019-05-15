package com.atguigu.bookstore.dao.impl;

import java.util.List;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.dao.BaseDao;
import com.atguigu.bookstore.dao.BookDao;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public List<Book> getBooks() {
		// 写sql语句
		String sql="select * from books";
		List<Book> beanList = getBeanList(sql);
		return beanList;
		
	
	}

	@Override
	public void saveBook(Book book) {
		// 写sql语句
		String sql="insert into books(title,author,price,sales,stock,img_Path) values(?,?,?,?,?,?)";
		update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
	}

	@Override
	public void deleteBookById(String bookId) {
		// 写sql语句
		String sql="delete from books where id=?";
		update(sql, bookId);
	}

	@Override
	public Book getBookById(String bookId) {
		// 写sql语句
		String sql="select id,title,author,price,sales,stock,img_path imgPath from books where id=?";
		Book bean = getBean(sql, bookId);
		return bean;
	}

	@Override
	public void updateBookById(Book book) {
		// 写sql语句
		String sql = "update books set title = ? , author = ? , price = ? , sales = ? , stock = ? where id = ?";
		update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getId());
		
	}

}

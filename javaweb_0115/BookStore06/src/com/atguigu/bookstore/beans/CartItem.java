package com.atguigu.bookstore.beans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 购物项类
 * 
 * @author hanya
 *
 */
public class CartItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Book book; // 图书信息
	private int count; // 购物项中图书的数量
	// private double amount; // 购物项中的金额小计，通过计算得到

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	// 购物项中的金额小计由图书的价格和购物项中图书的数量计算得到
	public double getAmount() {
		BigDecimal bigPrice = new BigDecimal(book.getPrice()+"");
		BigDecimal bigCount = new BigDecimal(count+"");
		return bigPrice.multiply(bigCount).doubleValue();
	}

}

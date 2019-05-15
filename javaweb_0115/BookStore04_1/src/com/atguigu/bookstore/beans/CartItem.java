package com.atguigu.bookstore.beans;



public class CartItem {
	//图书信息属性
  private Book book;
  //购物项中每本图书的本数
  private int count;
  //每种图书的总金额
  //private double amount;
  
public Book getBook() {
	return book;
}
public CartItem(Book book, int count) {
	super();
	this.book = book;
	this.count = count;
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
public double getAmount() {
	return book.getPrice()*count;
}
  
  



 
  
}

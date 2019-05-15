package com.atguigu.bookstore.test;

import org.junit.Test;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Cart;
public class TestCart{
	

@Test
public void Test() {
	//创建两本Book
	Book book = new Book(1, "小王子", "老王", 666.00, 1000, 10);
	Book book2 = new Book(2, "隔壁老王的故事", "王彭", 334.00, 1000, 10);
	
	//创建购物车
	Cart cart = new Cart();
	//将book和book2添加到购物车
	cart.addBook2Cart(book);
	cart.addBook2Cart(book2);
	
	//再买一本book2
	cart.addBook2Cart(book2);
	
	//更新购物车中book的数量
   // cart.updateCartItem("1","5");
	
	//删除book
   // cart.deleteCartItem("1");
	
	//清空购物车
   // cart.emptyCart();
    System.out.println("购物车中图书的总数量是："+cart.getTotalCount());
	System.out.println("购物车中图书的总金额是："+cart.getTotalAmount());
	
}}

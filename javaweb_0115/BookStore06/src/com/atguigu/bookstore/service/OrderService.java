package com.atguigu.bookstore.service;

import com.atguigu.bookstore.beans.Cart;
import com.atguigu.bookstore.beans.User;

public interface OrderService {

	/**
	 * 去结账
	 * 
	 * @param user
	 * @param cart
	 * @return
	 */
	String createOrder(User user, Cart cart);
}

package com.atguigu.bookstore.service;

import com.atguigu.bookstore.beans.Cart;
import com.atguigu.bookstore.beans.User;

public interface OrderService {
	String createOrder(User user,Cart cart);
}

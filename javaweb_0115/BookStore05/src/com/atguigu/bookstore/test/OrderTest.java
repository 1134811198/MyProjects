package com.atguigu.bookstore.test;

import java.util.Date;

import org.junit.Test;

import com.atguigu.bookstore.beans.Order;
import com.atguigu.bookstore.beans.OrderItem;
import com.atguigu.bookstore.dao.OrderDao;
import com.atguigu.bookstore.dao.OrderItemDao;
import com.atguigu.bookstore.dao.impl.OrderDaoImpl;
import com.atguigu.bookstore.dao.impl.OrderItemDaoImpl;

public class OrderTest {

	OrderDao orderDao = new OrderDaoImpl();
	OrderItemDao orderItemDao = new OrderItemDaoImpl();
	
	@Test
	public void test() {
		//创建一个Order对象
		Order order = new Order("13838381438999111", new Date(), 10, 1000.00, 0, 1);
		//创建两个OrderItem对象
		OrderItem orderItem = new OrderItem(null, 4, 400.00, "金瓶梅", "兰陵笑笑生", 100.00, "static/img/default.jpg", "13838381438999111");
		OrderItem orderItem2 = new OrderItem(null, 6, 600.00, "金莲自传", "郭梦洁", 100.00, "static/img/default.jpg", "13838381438999111");
		//将订单和订单项保存到数据库
		orderDao.saveOrder(order);
		orderItemDao.saveOrderItem(orderItem);
		orderItemDao.saveOrderItem(orderItem2);
	}

}

package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.beans.OrderItem;

public interface OrderItemDao {

	/**
	 * 向数据库中插入订单项
	 * 
	 * @param orderItem
	 */
	void saveOrderItem(OrderItem orderItem);

	/**
	 * 批量插入订单项
	 * 
	 * @param params
	 */
	void batchInsertOrderItems(Object[][] params);
}

package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.beans.OrderItem;

public interface OrderItemDao {
   void saveOrderItem(OrderItem orderItem);
   void batchInsertOrderItems(Object[][] params);
}

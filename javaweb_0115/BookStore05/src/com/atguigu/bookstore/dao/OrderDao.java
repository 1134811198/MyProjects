package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.beans.Order;

public interface OrderDao {
    void saveOrder(Order order);
}

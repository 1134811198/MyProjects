package com.atguigu.bookstore.service.impl;

import java.util.Date;
import java.util.List;

import com.atguigu.bookstore.beans.Book;
import com.atguigu.bookstore.beans.Cart;
import com.atguigu.bookstore.beans.CartItem;
import com.atguigu.bookstore.beans.Order;
import com.atguigu.bookstore.beans.OrderItem;
import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.dao.BookDao;
import com.atguigu.bookstore.dao.OrderDao;
import com.atguigu.bookstore.dao.OrderItemDao;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;
import com.atguigu.bookstore.dao.impl.OrderDaoImpl;
import com.atguigu.bookstore.dao.impl.OrderItemDaoImpl;
import com.atguigu.bookstore.service.OrderService;

public class OrderServiceImpl implements OrderService {

	OrderDao orderDao = new OrderDaoImpl();
	OrderItemDao orderItemDao = new OrderItemDaoImpl();
	BookDao bookDao = new BookDaoImpl();
	
	@Override
	public String createOrder(User user , Cart cart) {
		// 获取用户的id
		Integer userId = user.getId();
		// 生成订单号
		String orderId = System.currentTimeMillis() + "" + userId;
		//获取购物车中图书的总数量
		int totalCount = cart.getTotalCount();
		//获取购物车中图书的总金额
		double totalAmount = cart.getTotalAmount();
		//创建订单
		Order order = new  Order(orderId, new Date(), totalCount, totalAmount, 0, userId);
		//将订单插入到数据库中
		orderDao.saveOrder(order);
		
		//获取购物车中所有的购物项
		List<CartItem> cartItems = cart.getCartItems();
		
		//创建两个二维数组
		Object[][] orderItemParams = new Object[cartItems.size()][];
		Object[][] bookParams = new Object[cartItems.size()][];
		for(int i = 0 ; i < cartItems.size() ; i ++) {
			//获取每一个购物项
			CartItem cartItem = cartItems.get(i);
			//获取购物项中图书的数量
			int count = cartItem.getCount();
			//获取购物项中的金额小计
			double amount = cartItem.getAmount();
			//获取购物项中的Book
			Book book = cartItem.getBook();
			//获取书名
			String title = book.getTitle();
			//获取作者
			String author = book.getAuthor();
			//获取图书的价格
			double price = book.getPrice();
			//获取图书封面
			String imgPath = book.getImgPath();
			//创建订单项
//			OrderItem orderItem = new OrderItem(null, count, amount, title, author, price, imgPath, orderId);
			//将订单项插入到数据库中
//			orderItemDao.saveOrderItem(orderItem);
			orderItemParams[i] = new Object[] {count, amount, title, author, price, imgPath, orderId};
			
			//获取该图书的库存和销毁
			Integer sales = book.getSales();
			Integer stock = book.getStock();
			//重新设置该图书的库存和销量
//			book.setSales(sales + count);
//			book.setStock(stock - count);
			//更新图书的库存和销量
//			bookDao.updateBookById(book);
			//update books set sales = ? , stock = ? where id = ?
			bookParams[i] = new Object[] {sales + count , stock - count , book.getId()};
		}
		//批量插入订单项
		orderItemDao.batchInsertOrderItems(orderItemParams);
		//批量更新图书的库存和销量
		bookDao.batchUpdateSalesAndStock(bookParams);
		
		//接完账之后要清空购物车
		cart.emptyCart();
		return orderId;
	}

}

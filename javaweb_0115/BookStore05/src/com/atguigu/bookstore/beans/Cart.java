package com.atguigu.bookstore.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车类
 * 
 * @author hanya
 *
 */
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// map中的key是图书的id，map中的值是购物项
	private Map<String, CartItem> map = new LinkedHashMap<>();
	// private int totalCount; // 购物车中图书的总数量，通过计算得到
	// private double totalAmount; // 购物车中图书的总金额，通过计算得到

	// 将图书添加到购物车
	public void addBook2Cart(Book book) {
		// 获取该图书在购物车中对应的购物项
		CartItem cartItem = map.get(book.getId() + "");
		if (cartItem == null) {
			// 证明原来购物车中还没有该购物项
			cartItem = new CartItem();
			// 将图书设置到该购物项中
			cartItem.setBook(book);
			// 将图书的数量设置为1
			cartItem.setCount(1);
			// 将cartItem添加到map中
			map.put(book.getId() + "", cartItem);
		} else {
			// 证明购物车中已经有该购物项，只需要将该购物项中图书的数量加1即可
			cartItem.setCount(cartItem.getCount() + 1);
		}
	}

	// 更新购物项
	public void updateCartItem(String bookId, String bookCount) {
		// 获取要更新的图书对应的购物项
		CartItem cartItem = map.get(bookId);
		// 将String类型的图书的数量进行强转
		try {
			int parseInt = Integer.parseInt(bookCount);
			// 当parseInt大于0时再更新购物项中图书的数量
			if (parseInt > 0) {
				cartItem.setCount(parseInt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 删除购物项
	public void deleteCartItem(String bookId) {
		map.remove(bookId);
	}

	// 清空购物车
	public void emptyCart() {
		map.clear();
	}

	// 获取购物车中所有购物项
	public List<CartItem> getCartItems() {
		// 获取Map中所有的购物项
		Collection<CartItem> values = map.values();
		return new ArrayList<>(values);
	}

	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}

	// 购物车中图书的总数量是各个购物项中图书的数量之和
	public int getTotalCount() {
		int totalCount = 0;
		// 获取所有的购物项
		List<CartItem> cartItems = getCartItems();
		for (CartItem cartItem : cartItems) {
			// totalCount = totalCount + cartItem.getCount;
			totalCount += cartItem.getCount();
		}
		return totalCount;
	}

	// 购物车中图书的总金额是各个购物项中图书的金额小计之和
	public double getTotalAmount() {
//		double totalAmount = 0;
		BigDecimal totalAmount = new BigDecimal("0");
		// 获取所有的购物项
		List<CartItem> cartItems = getCartItems();
		for (CartItem cartItem : cartItems) {
//			totalAmount += cartItem.getAmount();
			BigDecimal bigAmount = new BigDecimal(cartItem.getAmount()+"");
			totalAmount = totalAmount.add(bigAmount);
		}
		return totalAmount.doubleValue();
	}

}

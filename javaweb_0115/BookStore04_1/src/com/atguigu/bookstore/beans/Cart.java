package com.atguigu.bookstore.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
	//bookId和购物项
     private Map<String,CartItem> map=new LinkedHashMap<String,CartItem>();
     //购物车中商品的总数量
     private int totalCount;
     //购物车中商品的总价钱
     private double totalAmount;
     
     //获取购物车中所有的购物项
    public  List<CartItem>  getCartItems() {
    	Collection<CartItem> cartItems = map.values();
    	
		return new ArrayList<>(cartItems); 
    	 
     }
    // 将图书添加到购物车// 获取该图书在购物车中对应的购物项// 证明原来购物车中还没有该购物项将图书设置到该购物项中
    public void addBook2Cart(Book book) {
    	CartItem cartItem = map.get(book.getId()+"");
    	if(cartItem == null) {
    		cartItem=new CartItem(book, 1);
    		map.put(book.getId()+"", cartItem);
    	}else {
    		cartItem.setCount(cartItem.getCount()+1);
    	}
    }
 // 更新购物项
    public void updateCartItem(String bookId, String bookCount){
    	CartItem cartItem = map.get(bookId);
    	 try {
			int parseInt = Integer.parseInt(bookCount);
			if(parseInt>0) {
				cartItem.setCount(parseInt);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	 
    }
 // 删除购物项
    public void deleteCartItem(String BookId) {
    	map.remove(BookId);
    }
 // 清空购物车
    public void emptyCart() {
    	
    	map.clear();
    }
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	public int getTotalCount() {
		
		int totalCount=0;
		List<CartItem> cartItems = getCartItems();
		for (CartItem cartItem : cartItems) {
			totalCount +=cartItem.getCount();
		}
		return totalCount;
	}
	public double getTotalAmount() {
		int totalAmount=0;
		List<CartItem> cartItems = getCartItems();
		for (CartItem cartItem : cartItems) {
			totalAmount += cartItem.getCount();
		}
		return totalAmount;
	}
     

   
}

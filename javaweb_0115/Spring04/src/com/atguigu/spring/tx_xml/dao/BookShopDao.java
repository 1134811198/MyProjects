package com.atguigu.spring.tx_xml.dao;

public interface BookShopDao {
	//1.根据书号查询书的价格
	public int findBookPriceByIsbn(String isbn);
	
	//2.更新书的库存
	public void updateBookStock(String isbn);
	
	//3.更新用户的余额
	public void updateUserAccount(String username, Integer price );
}

package com.atguigu.spring.tx.dao;

public interface BookshopDao {
/*
 * 按书号查图书价格
 */
	public Integer findBookPriceByIsbn(String isbn);
	/*
	 * 更新书的库存
	 */
	public void updateBookStock(String isbn);
	/*
	 * 更新用户余额
	 */
	public void updateUserAccount(Integer price,String username);
}

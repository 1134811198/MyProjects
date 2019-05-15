package com.atguigu.SpringAop.Dao;

public interface BookshopDao {
  
	public Integer findPriceByIsbn(String isbn);
    public void updateStock(String isbn);
    public void updateAccount(String lastName,Integer price);
    
	
}

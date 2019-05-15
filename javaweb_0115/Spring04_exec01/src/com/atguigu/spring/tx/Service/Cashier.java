package com.atguigu.spring.tx.Service;

import java.util.List;

public interface Cashier {
 /*
  * 模拟用户结账  
  */
	public void Checkout(String username,List<String> isbn) ;
		
	
}

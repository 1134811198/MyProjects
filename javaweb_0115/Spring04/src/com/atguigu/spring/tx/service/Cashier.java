package com.atguigu.spring.tx.service;

import java.util.List;

public interface Cashier {
	
	//模拟用户的结账
	public void  checkOut(String username, List<String> isbn);
}

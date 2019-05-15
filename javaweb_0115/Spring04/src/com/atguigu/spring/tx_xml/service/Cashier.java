package com.atguigu.spring.tx_xml.service;

import java.util.List;

public interface Cashier {
	
	//模拟用户的结账
	public void  checkOut(String username, List<String> isbn);
}

package com.atguigu.Springss.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	public UserDao() {
		System.out.println("UserDao....");
	}
	public void addUser() {
		System.out.println("Jdbc add user.....");
		
	}

	
}

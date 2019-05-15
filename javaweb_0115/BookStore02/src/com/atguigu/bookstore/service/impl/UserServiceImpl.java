package com.atguigu.bookstore.service.impl;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.dao.UserDao;
import com.atguigu.bookstore.dao.impl.UserDaoImpl;
import com.atguigu.bookstore.service.UserService;

public class UserServiceImpl implements UserService{

	UserDao userDao = new UserDaoImpl();

	public User login(User user) {
		User user2 = userDao.getUser(user);
		return user2;
	}

	public boolean regist(User user) {
		boolean flag = userDao.checkUsername(user);
		return !flag;
	}

	public void saveUser(User user) {
		
		userDao.saveUser(user);
	}
	
	

}

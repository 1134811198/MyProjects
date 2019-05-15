package com.atguigu.bookstore.test;



import org.junit.Test;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.dao.UserDao;
import com.atguigu.bookstore.dao.impl.UserDaoImpl;

public class UserDaoTest {

	UserDao userDao = new UserDaoImpl();

	@Test
	void testGetUser() {
		// 封装user对象
		User user = new User(null, "admin", "123456", null);
		// 调用UserDao的方法获取User对象
		User user2 = userDao.getUser(user);
		System.out.println(user2);
	}

	@Test
	void testCheckUsername() {
		// 封装user对象
		User user = new User(null, "admin2", null, null);
		boolean flag = userDao.checkUsername(user);
		System.out.println(flag);
	}

	@Test
	void testSaveUser() {
		// 封装user对象
		User user = new User(null, "admin2", "123456", "admin2@sina.com");
		userDao.saveUser(user);
	}

}

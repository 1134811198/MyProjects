package com.atguigu.Springss.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.Springss.dao.UserDao;
@Service
public class UserService {
    @Autowired
	UserDao userDao;
	public UserService() {
		System.out.println("UserService....");
	}
	public void addUser() {
		userDao.addUser();
	}

}

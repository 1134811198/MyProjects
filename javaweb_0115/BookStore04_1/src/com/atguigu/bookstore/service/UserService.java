package com.atguigu.bookstore.service;

import com.atguigu.bookstore.beans.User;

public interface UserService {

	/**
	 * 处理用户登录的方法
	 * 
	 * @param user
	 * @return User 登录成功 null 登录失败
	 */
	User login(User user);

	/**
	 * 处理用户注册的方法
	 * 
	 * @param user
	 * @return true 注册成功 false 注册失败
	 */
	boolean regist(User user);

	/**
	 * 保存用户的方法
	 * 
	 * @param user
	 */
	void saveUser(User user);

}

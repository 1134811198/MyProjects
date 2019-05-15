package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.beans.User;

public interface UserDao {

	/**
	 * 根据传入的User对象中的用户名和密码从数据库中查询对应的记录
	 * 
	 * @param user
	 *            根据获取的用户输入的用户和密码封装的Ueser对象
	 * @return User从数据库中查询出来的记录封装的User对象	null 数据库中没有对应的记录
	 */
	User getUser(User user);

	/**
	 * 根据传入的User对象中的用户名看数据库中是否有对应的记录
	 * 
	 * @param user
	 * @return true 数据库中有该记录 false 数据库中无此记录
	 */
	boolean checkUsername(User user);

	/**
	 * 将用户保存到数据库中
	 * 
	 * @param user
	 */
	void saveUser(User user);
}

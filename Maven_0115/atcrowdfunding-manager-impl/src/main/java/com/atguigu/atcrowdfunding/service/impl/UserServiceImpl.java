package com.atguigu.atcrowdfunding.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.dao.UserDao;
import com.atguigu.atcrowdfunding.exception.LoginFailureException;
import com.atguigu.atcrowdfunding.service.UserService;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.MD5Util;
import com.atguigu.atcrowdfunding.util.Page;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User login(Map<String, Object> paramMap) {
		
		String userpswd = (String) paramMap.get("userpswd");
		String newUserpswd = MD5Util.digest(userpswd);
		
		paramMap.put("userpswd", newUserpswd);
			User user = userDao.login(paramMap);
			
			
			if(user == null) {
				throw new LoginFailureException("用户名不存在");
			}
			if(!user.getUserpswd().equals(newUserpswd)) {
				throw new LoginFailureException("密码错误");
			}
			
			return user;
		
		
	}

	public Page<User> queryPage(Map<String, Object> paramMap) {
		
		Integer pageno = (Integer) paramMap.get("pageno");
		Integer pagesize = (Integer) paramMap.get("pagesize");
		Page<User> page=new Page<User>(pageno,pagesize);

		int startindex = page.getStartindex();
		//System.out.println(startindex);
		paramMap.put("startindex", startindex);
		List<User> list = userDao.queryPage(paramMap);
		int totalsize = userDao.count(paramMap);
		page.setDatas(list);
		page.setTotalsize(totalsize);

		return page;
	}

	public int saveUser(User user) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String createtime = sdf.format(new Date());
		System.out.println(createtime.length());
		user.setUserpswd(MD5Util.digest(Const.DEFAULT_PSWD));
		user.setCreatetime(createtime);
		return userDao.saveUser(user);
	}

	public int update(User user) {
		
		return userDao.updateByPrimaryKey(user);
	}


	


}

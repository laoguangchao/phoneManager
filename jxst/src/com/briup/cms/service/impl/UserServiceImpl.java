package com.briup.cms.service.impl;

import com.briup.cms.bean.User;
import com.briup.cms.dao.UserDao;
import com.briup.cms.service.IUserService;

public class UserServiceImpl implements IUserService  {
	private UserDao UserDao = new UserDao();
	@Override
	public void add(User user) {
		UserDao.save(user);
		
	}
	public User login(User user){
		return UserDao.login(user);
	}
	
}

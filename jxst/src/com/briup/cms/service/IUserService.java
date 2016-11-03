package com.briup.cms.service;

import com.briup.cms.bean.User;

public interface IUserService {
	void add(User user);
	User login(User user);
}

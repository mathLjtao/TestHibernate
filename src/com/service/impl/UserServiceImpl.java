package com.service.impl;

import com.dao.UserDao;
import com.domain.User;
import com.domain.Users;
import com.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao ud;
	@Override
	public Users login(Users users) {
		// TODO Auto-generated method stub
		Users user = ud.login(users);
		return user;
	}
	@Override
	public User login(User user) {
		User crmUser=ud.login(user);
		// TODO Auto-generated method stub
		return crmUser;
	}
	//这个不能省略
	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	
}

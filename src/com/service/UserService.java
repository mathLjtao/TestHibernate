package com.service;

import com.domain.*;

public interface UserService {
	//自己数据库的测试Users
	Users login(Users users);
	//crm数据库的sys_user
	User login(User user);
}

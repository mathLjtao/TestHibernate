package com.dao;

import com.domain.*;

public interface UserDao {
	Users login(Users users);
	User login(User user);
}

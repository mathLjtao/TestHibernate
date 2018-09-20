package com.service;

import com.dao.CustomerDao;
import com.domain.Users;

public interface CustomerService {
	Users login(Users users);
}

package com.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.UserDao;
import com.domain.User;
import com.domain.Users;
import com.utils.HibernateUtil;

public class UserDaoImpl implements UserDao{
	 public Users login(Users users){
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Users user = session.get(Users.class, users.getId());
		tx.commit();
		return user;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrentSession();
		Transaction tx=session.beginTransaction();
		String hql="from User where user_id=? and user_password=?";
		Query createQuery = session.createQuery(hql);
		createQuery.setParameter(0, user.getUser_id());
		createQuery.setParameter(1, user.getUser_password());
		User exitsUser = (User)createQuery.uniqueResult();
		tx.commit();
		return exitsUser;
	}
}

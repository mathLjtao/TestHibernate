package com.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory= buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try{
			return new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex){
			System.out.println("Initial SessionFactory creation failed."+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	//获得与当前线程绑定的session
	public static Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
}

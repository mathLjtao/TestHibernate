package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.domain.Users;
import com.utils.HibernateUtil;

public class TestHibernateSelect {
	public  static void main(String[] args){
		/*
		 * 1.加载配置文件：
		 * 通常使用Configuration config=new Configuration().configure();的方式创建实例，此种方式默认会去src下
		 * 读取hibernate.cfg.xml配置文件。
		 * 如果是Configuration config=new Configuration().configure("/config/hibernate.cfg.xml");
		 * 会读取src下config包中的hibernate.cfg.xml
		*/
		Configuration config=new Configuration().configure();
		//2.创建一个SessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory();
		//3.创建session对象，session对象，类似Connection
		Session session=sessionFactory.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		//4.用session对象执行相关操作
		//根据主键查询 数据库的一条数据，这里的表中主键是int类型的，所以直接输入数字，如果是String的需要加""
		Users user=session.get(Users.class,11);
		System.out.println("Users(user):"+user.getUser());
		//事务提交
		tx.commit();
		session.close();
	}
	@Test
	/*
	 * 运用HibernateUtil来获得sessionFactory
	 * 查询数据库Users表中所有数据
	 */
	public void demo1(){
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Users users=new Users();
		//这个 from Users 是从配置文件中的 name="Users"那个，不是数据库表名那个
		List list=session.createQuery(" from Users ").list();
		for(int i=0;i<list.size();i++){
			 users = (Users)list.get(i);
			 System.out.println("user:"+users.getUser()+";phone:"+users.getPhone());
		}
		tx.commit();
		session.close();
	}
}

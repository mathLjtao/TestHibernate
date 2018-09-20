package lin.hibernate02.operationJDBC;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.domain.Users;
import com.utils.HibernateUtil;

public class QueryMode {
	public static  void main(String[] args){
		QueryMode mode=new QueryMode();
		mode.HQLBaseQuery();
		
	} 
	/*
	 * 一、HQL查询-hibernate Query Language(多表查询,但不复杂时使用)
	 * 1.基本查询
	 * 2.条件查询：（1）?号占位符；（2）命名占位符
	 * 3.分页查询
	 */
	@Test
	public  void HQLBaseQuery(){
		Configuration cf=new Configuration().configure();
		SessionFactory sf=cf.buildSessionFactory();
		Session session=sf.openSession();
		String hql=" from Users";//书写hql语句
		Query query = session.createQuery(hql);
		List<Users> list = query.list();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}
		session.close();
		sf.close();
	}
	@Test
	public  void HQLConditionQuery(){
		Configuration cf=new Configuration().configure();
		SessionFactory sf=cf.buildSessionFactory();
		Session session=sf.openSession();
		//String hql=" from Users where id=?";//?好占位符查询
		String hql=" from Users where id=:id";//命名占位符查询
		Query query = session.createQuery(hql);
		//query.setParameter(0, 11);
		query.setParameter("id", 10);
		Users users = (Users) query.uniqueResult();
		System.out.println(users.toString());
		session.close();
		sf.close();
	}
	@Test
	//分页查询
	public  void HQLQueryWithPage(){
		Configuration cf=new Configuration().configure();
		SessionFactory sf=cf.buildSessionFactory();
		Session session=sf.openSession();
		String hql=" from Users";//
		Query query = session.createQuery(hql);
		query.setFirstResult(2);
		query.setMaxResults(3);
		List<Users> list = query.list();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}
		session.close();
		sf.close();
	}
	/*
	 * 二、Criteria查询(单表条件查询)，无语句面向对象查询
	 * 1.基本查询
	 * 2.条件查询
	 * 3.分页查询
	 * 4.设置查询总记录数
	 */
	@Test
	public  void criteriaBaseQuery(){
		Configuration cf=new Configuration().configure();
		SessionFactory sf=cf.buildSessionFactory();
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Users.class);
		List<Users> list = criteria.list();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}
		session.close();
		sf.close();
	}
	/*
	 * (>,gt),(>=,ge),(<,lt),(<=,le),(==,eq),(!=,ne),
	 * (in,in),(between and,between),(like,like),(or,or),(and,and)
	 * (is not null,isNotNull),(is null,isNull)
	 */
	@Test
	public  void criteriaIfQuery(){
		Configuration cf=new Configuration().configure();
		SessionFactory sf=cf.buildSessionFactory();
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Users.class);
		criteria.add(Restrictions.eq("id", 11));
		Users users = (Users) criteria.uniqueResult();
		System.out.println(users.toString());
		session.close();
		sf.close();
	}
	@Test
	public  void criteriaQueryWithPage(){
		Configuration cf=new Configuration().configure();
		SessionFactory sf=cf.buildSessionFactory();
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Users.class);
		criteria.setFirstResult(2);
		criteria.setMaxResults(3);
		List<Users> list = criteria.list();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}
		session.close();
		sf.close();
	}
	/*
	 * 三、原生SQL查询(复杂的业务查询)
	 * 1.基本查询：（1）返回数据List；（2）返回对象List
	 * 2.条件查询
	 * 3.分页查询
	 */
	@Test
	public  void SqlBaseQueryList1(){
		Configuration cf=new Configuration().configure();
		SessionFactory sf=cf.buildSessionFactory();
		Session session=sf.openSession();
		String sql="select * from users ";
		SQLQuery query = session.createSQLQuery(sql);
		List<Object[]> list = query.list();//返回数据List
		for(int i=0;i<list.size();i++){
			System.out.println(Arrays.toString(list.get(i)));
		}
		session.close();
		sf.close();
	}
	@Test
	public  void SqlBaseQueryList2(){
		Configuration cf=new Configuration().configure();
		SessionFactory sf=cf.buildSessionFactory();
		Session session=sf.openSession();
		String sql="select * from users ";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Users.class);//指定将结果集封装到哪个对象中
		List<Users> list = query.list();//返回对象List
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}
		session.close();
		sf.close();
	}
	@Test
	public  void SqlIfQuery(){
		Configuration cf=new Configuration().configure();
		SessionFactory sf=cf.buildSessionFactory();
		Session session=sf.openSession();
		String sql="select * from users where id = ?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, 10);
		query.addEntity(Users.class);
		List<Users> list = query.list();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}
		session.close();
		sf.close();
	}
	@Test
	public  void SqlQueryWithPage(){
		Configuration cf=new Configuration().configure();
		SessionFactory sf=cf.buildSessionFactory();
		Session session=sf.openSession();
		String sql="select * from users limit  ?,?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, 5);
		query.setParameter(1, 3);
		query.addEntity(Users.class);
		List<Users> list = query.list();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}
		session.close();
		sf.close();
	}
	/*
	 * 离线条件查询：DetachedCriteria
	 * 可以脱离session设置参数
	*/
	@Test
	public void detachedCriteria(){
		//获得一个离线条件查询的对象
		DetachedCriteria dc=DetachedCriteria.forClass(Users.class);
		//dc.add(Restrictions.eq("user","林一"));
		Session session=HibernateUtil.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<Users> list = dc.getExecutableCriteria(session).list();
		for(Users user:list){
			System.out.println(user.toString());
		}
		tx.commit();
	}
}

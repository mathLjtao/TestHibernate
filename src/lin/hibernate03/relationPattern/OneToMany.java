package lin.hibernate03.relationPattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.domain.Customer;
import com.domain.LinkMan;
import com.utils.HibernateUtil;

public class OneToMany {
	public static void main(String[] args){
		OneToMany onToMany=new OneToMany();
		onToMany.test2();
	}
	@Test
	//测试数据的关联保存
	public void test1(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Customer customer=new Customer();
		LinkMan lm1=new LinkMan();
		LinkMan lm2=new LinkMan();
		customer.setCust_name("林总");
		lm1.setLkm_name("张秘书");
		lm2.setLkm_name("李助理");
		//建立关系
		customer.getLinkMans().add(lm2);
		customer.getLinkMans().add(lm1);
		lm1.setCustomer(customer);
		lm2.setCustomer(customer);
		//Customer映射文件设置了cascade="save-update"的情况下。
		session.save(customer);
		tx.commit();
		session.close();
		sf.close();
	}
	@Test
	//测试数据的关联删除
	public void test2(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Customer customer=session.get(Customer.class, 3);
		
		session.delete(customer);
		
		
		tx.commit();
		session.close();
		sf.close();
	}
}

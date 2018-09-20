package lin.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

	public static void main(String[] args) {
		// 获取无参的构造方法模式
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao bean = (UserDao)ac.getBean("userDao");//是接口对象，然后下面执行的方法是实现该接口的对象的方法
		bean.sayHello();
		
		//获取静态的工厂实例的模式
		UserDao staticBean=(UserDao)ac.getBean("userDaoStaticBean");
		staticBean.staticInfo();
		
		UserDao commBean=(UserDao)ac.getBean("userDaoStaticBean");
		commBean.commInfo();
		
		UserDaoImpl beanPro = (UserDaoImpl)ac.getBean("userDao");
		System.out.println(beanPro.getName());
	}
}

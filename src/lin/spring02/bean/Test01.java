package lin.spring02.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ap=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao=(UserDao)ap.getBean("UserDao");
		userDao.sayHello();
	}

}

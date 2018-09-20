package com.web.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.domain.Users;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CustomerService;
import com.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<Users>{
	private Users users=new Users();//这里不能写成 parive Users users;一定要new一个对象出来
	public String login() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us=(UserService)ac.getBean("userService");
		int id=(int)ServletActionContext.getRequest().getAttribute("id");
		String password=ServletActionContext.getRequest().getAttribute("password").toString();
		//users.setId(id);
		//users.setPassword(password);
		System.out.println(users.toString());
		Users user = us.login(users);
		System.out.println(user.toString());
		return "action1";
	}
	@Override
	public Users getModel() {
		return users;
	}

}

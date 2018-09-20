package com.web.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;

public class CrmUserAction extends ActionSupport implements ModelDriven<User>{
	private User user=new User();
	
	public String login(){
		//获得servletContext对象
		ServletContext sc=ServletActionContext.getServletContext();
		//从sc中获得容器
		WebApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sc);
		UserService us=(UserService)ac.getBean("userService");
		User existUser=us.login(user);
		if(existUser!=null){
			ActionContext.getContext().getSession().put("existUser", existUser);
			return "success";
		}
		else{
			this.addActionError("用户名或密码错误！");
			return "toLogin";
		}
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}

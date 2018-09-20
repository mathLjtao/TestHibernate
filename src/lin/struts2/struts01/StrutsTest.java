package lin.struts2.struts01;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class StrutsTest extends ActionSupport {
	public String test1(){
		
		String info="服务器端的信息！！(test1)";
		ServletActionContext.getRequest().setAttribute("test_info", info);
		return "test1";
	}
	public String test2(){
		String info="服务器端的信息！！(test2)";
		ServletActionContext.getRequest().setAttribute("test_info", info);
		return "test2";
	}
}

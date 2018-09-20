package lin.struts2.struts01;

public class StrutsDemo1 {
	//一个默认的执行方法
	public String execute(){
		System.out.println("StrutsDemo1中的execute执行了...");
		//返回的这个值（这里是success），这个值是去找struts.xml中的<result/>对应的name
		return "success";
	}
}

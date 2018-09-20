package lin.spring02.bean;

import org.springframework.stereotype.Component;
/*
 * Spring 中提供 @Component 的三个衍生注解 :( 功能目前来讲是一致的 ) 
 * * @Controller :WEB 层 
 * * @Service :业务层 业务层 
 * * @Repository :持久层 持久层 
 * 	这三个注解是为了让标类本身的用途清晰， Spring 在后续版本会对其增强 在后续版本会对其增强 在后续版本会对其增强
 */
@Component(value="UserDao")
public class UserDaoImpl implements UserDao{
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("Hello world!!!");
	}
	
}

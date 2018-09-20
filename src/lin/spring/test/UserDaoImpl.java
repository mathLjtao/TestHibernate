package lin.spring.test;

public class UserDaoImpl implements UserDao{
	private String name;
	@Override
	public void sayHello() {
		System.out.println("hello world!!!");
	}
	public void staticInfo() {
		System.out.println("静态工厂实例化方式成功！！！");
	}
	public void commInfo(){
		System.out.println("实例工厂实例化方式成功！！！");
	}
	public static UserDaoImpl getStaticUserDao(){
		return new UserDaoImpl();
	}
	public  UserDaoImpl getCommUserDao(){
		return new UserDaoImpl();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

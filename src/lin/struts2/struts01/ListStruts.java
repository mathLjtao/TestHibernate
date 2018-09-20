package lin.struts2.struts01;

import java.util.List;
import java.util.Map;

import com.domain.Users;
import com.opensymphony.xwork2.ActionSupport;

public class ListStruts extends ActionSupport {
	private List<Users> list;
	private Map<String,Users> map;
	public List<Users> getList(){
		return list;
	}
	public void setList(List<Users> list){
		this.list=list;
	}
	public Map<String,Users> getMap(){
		return map;
	}
	public void setMap(Map<String,Users> map){
		this.map=map;
	}
	public String list01(){
		for(Users user:list){
			System.out.println(user.toString());
		}
		return "list";
	}
	public String map01(){
		for(String key:map.keySet()){
			Users us=map.get(key);
			System.out.println(key+",,"+us.toString());
		}
		return "map";
	}
}

package lin.struts2.struts01;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

import org.junit.Test;

import com.domain.Users;

public class TestOgnl {
	@Test
	public void run1() throws OgnlException{
		OgnlContext context=new OgnlContext();
		Object str = Ognl.getValue("@java.lang.Math@random()",context,context.getRoot());
		System.out.println(str);
		
	}
}

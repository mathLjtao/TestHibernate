<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/strutsDemo1.action">访问struts2的Action！！！</a><br>
<a href="${pageContext.request.contextPath }/struts_test1.action">多个访问的方式：1</a><br>
<a href="${pageContext.request.contextPath }/struts_test2.action">多个访问的方式：2</a><br>
从服务器返回的参数："${test_info }"
<form action="${pageContext.request.contextPath }/userAction_login"
	method="post">
	<table>
		<tr>
			<td>id：<input type="text" name="id"></td>
			<td>密码：<input type="text" name="password"></td>
			<td> <input type="submit" value="提交"></td>
		</tr>
	</table>
</form>

</body>
</html>
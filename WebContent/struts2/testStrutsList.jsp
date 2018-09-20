<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/testAction_list01.action">
id:<input type="text" name="list[0].id"/>
user:<input type="text" name="list[0].user"/>
password:<input type="text" name="list[0].password"/><br>
id:<input type="text" name="list[1].id"/>
user:<input type="text" name="list[1].user"/>
password:<input type="text" name="list[1].password"/>
<input type="submit" value="subimit"/>
</form>
</body>
</html>
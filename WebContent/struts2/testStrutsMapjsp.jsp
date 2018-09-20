<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/testAction_map01.action">
id:<input type="text" name="map['one'].id"/>
user:<input type="text" name="map['one'].user"/>
password:<input type="text" name="map['one'].password"/><br>
id:<input type="text" name="map['two'].id"/>
user:<input type="text" name="map['two'].user"/>
password:<input type="text" name="map['two'].password"/>
<input type="submit" value="subimit"/>
</form>
</body>
</html>
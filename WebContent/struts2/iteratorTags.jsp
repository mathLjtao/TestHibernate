<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
s:iterator的属性展示
	<table>
	<s:iterator value="{'java','mysql','oracle','c'}" var="name" status="st">
		<s:if test="#st.odd"><!-- 要加上一个‘#’号 -->
			<tr >
				<td style="backgroud-color: white"> 
				<s:property value="name"/>
				</td>
			</tr>
		</s:if>
		<s:else>
			<tr style="background-color: gray">
				<td>
				<s:property value="name"/>
				</td>
			</tr>
		</s:else>
	</s:iterator>
	</table>
	<hr>
	s:property的属性展示<br>
	输出字符串:<s:property value="'www.baidu.com'"/><br>
	忽略HTML代码<s:property value="'<h3> hahahah</h3>'" escape="true"/><br>
	不忽略HTML代码<s:property value="'<h3> hahahah</h3>'" escape="false"/><br>
	输出默认值：<s:property value="" default="TRUE"/>
	<hr>
	<s:form action="register">
		<s:textfield label="用户名" name="username"></s:textfield>
		<s:textarea label="描述" name="description" rows="1" cols="5"/>
		<%-- <s:password label="password" value="aaa" name="password" showPassword="true"></s:password> --%>
		<s:radio list="#{'0':'男','1':'女' }" key="0" ></s:radio><br>
		<%--
			<input type="radio" name="sex"  >男
			<input type="radio" name="sex" checked="checked">女
		--%>
		<s:checkboxlist label="爱好" name="inter" list="{'足球','篮球','游泳'}" labelposition="left"/><br>
		<s:checkboxlist label="课程" name="education" list="#{'0':'语文','1':'数学','2':'英语'}" labelposition="left" listKey="key" listValue="value"/><br>
		<%--
			<input type="checkbox" name="checkbox1" value="checkbox"> 跑步
			<input type="checkbox" name="checkbox2" value="checkbox"> 打球
			<input type="checkbox" name="checkbox3" value="checkbox"> 登山
			<input type="checkbox" name="checkbox4" value="checkbox"> 健美<br>
		--%>
		<s:select label="所在城市" name="city" list="#{'b':'北京','s':'上海','g':'广州'}" listkey="key" listvalue="value"></s:select>
		<s:file label="头像" name="upLoadFile"></s:file><br>
		<s:reset value="重置"></s:reset>
		<s:submit value="提交"></s:submit>
	</s:form>
	
</body>
</html>
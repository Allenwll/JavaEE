<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>更新学生</title>

</head>

<body>
	<h2>更新学生</h2>
	<form action="operator.action?method=update" method="post">
		学号<input type="text" name="id" value="${param.id}" /><br /> 姓名 <input
			type="text" name="name"> <br /> 年龄 <input type="text"
			name="age"> <br /> 成绩 <input type="text" name="score">
		<br /> 班级:<select name="clazz">
			<option value="1">JavaOO1</option>
			<option value="2">AndroidOO1</option>
			<option value="3">IOSOO1</option>
			<br />
			<br />
			<input type="submit" value="更新">
	</form>

</body>
</html>

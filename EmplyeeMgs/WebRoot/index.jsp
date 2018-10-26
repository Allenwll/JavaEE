<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>系统首页</title>

</head>

<body>
	<h3 style="text-align:center;">员工查询</h3>
	<a href="empAdd.jsp">增加新员工</a>
	<form action="employee.action?method=query" method="post"
		style="text-align:center;">
		姓名<input type="text" name="e_name" /><br /> <br /> <input
			type="submit" name="提交">
	</form>
	<br />
	<br />
	<table border="1" cellspacing="1" align="center" style="width:60%;">
		<tr>
			<th>员工编号</th>
			<th>员工姓名</th>
			<th>年龄</th>
			<th>工资</th>
			<th>地址</th>

		</tr>
		<c:forEach var="emp" items="${empList}">
			<tr>
				<th>${emp.e_no}</th>
				<th>${emp.e_name}</th>
				<th>${emp.e_age}</th>
				<th>${emp.e_laborage}</th>
				<th>${emp.e_address}</th>
			</tr>
		</c:forEach>
	</table>

</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>操作页面</title>

</head>

<body>
	<h2>操作管理</h2>
	<hr />
	<ol>
		<li><a href="operator.action?method=logOut">注销功能</a></li>
		<li><a href="operator.action?method=queryAll&uname=${username}&count=${myCount}">显示所有学生信息</a></li>
		<li><a href="add.jsp">添加学生</a></li>
		<li><a href="drop.jsp">删除学生</a></li>
		<li><a href="update.jsp">更新学生</a></li>
		<li><a href="register.jsp">用户注册</a></li>
	</ol>
</body>
</html>

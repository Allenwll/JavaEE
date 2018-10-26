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

<title>作用域</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<h1>作用域的学习</h1>
	<ol>
		<li><a href="request.action">Request作用域</a></li>
		<li><a href="session.action">Session作用域</a></li>
		<li><a href="application.action">Application作用域</a></li>
	</ol>
	<hr/>
	<ul>
		<li><a href="testScope.action">作用域测试</a></li>
	</ul>
	
</body>
</html>

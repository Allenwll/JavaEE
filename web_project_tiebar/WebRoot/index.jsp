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

<title>贴吧首页</title>


</head>

<body>
	<h1>欢迎进入尚学堂贴吧</h1>
	<br>
	<a href="topic.action?method=login">正式进入</a>
</body>
</html>

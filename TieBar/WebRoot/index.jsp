<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">
<title>开始界面</title>

</head>

<body>
	<h3>欢迎访问个人贴吧</h3>
	<a href="topic.action?method=list">点击进入</a>
</body>
</html>

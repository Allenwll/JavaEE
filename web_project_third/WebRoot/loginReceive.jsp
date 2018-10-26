<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jsp:include 动作实例</title>
</head>

<body>
	<!-- 获取用户名和密码 -->
	<%
		String Name = request.getParameter("userName");
		String Pwd = request.getParameter("password");
		if (Name.equals("java") && Pwd.equals("123456")) {
	%>
	<jsp:forward page="loginCorrect.html" />
	<%
		} else
	%>
	<jsp:forward page="loginError.html" />
</body>
</html>

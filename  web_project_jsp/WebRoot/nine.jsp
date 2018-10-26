<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>
	<h2>内置对象是什么？---jsp已经定义好的对象，对象有哪些？---》9种，能做什么？---》？</h2>
	<%=request.getParameter("uname")%>
	<%=request.getParameter("pwd")%>
	<h2>九大内置对象</h2>
	<ol>
		<h3>四大作用域</h3>
		<li>pageContext：当前页面上下文对象，可以获取其他8个对象，当前页，当前页</li>
		<li>request：将客户端请求信息进行封装</li>
		<li>session：客户端跟服务端的会话对象</li>
		<li>application：项目中唯一一个大作用域</li>
		<h3>三个打酱油</h3>
		<li>config：几乎不用</li>
		<li>page</li>
		<li>exception</li>
		<h3>二个输出</h3>
		<li>response：是服务端向客户端响应的信息对象</li>
		<li>out：是一个带缓存区的输出流对象，jsp推荐使用</li>
	</ol>
</body>
</html>

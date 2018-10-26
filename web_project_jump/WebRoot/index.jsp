<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>请求转发重定向</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <!--超链接  -->
    <a href="http://www.baidu.com">点击才能触发请求，不能满足自动更换请求地址</a>
  	
  	<h1>请求转发和重定向</h1>
 	<a href="dispatcher.action?phone=iphone6">测试请求转发</a>
 	<a href="redirect.action?iphone=iphone6plus">重定向</a>
  </body>
</html>

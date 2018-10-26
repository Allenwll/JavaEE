<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>表单</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <h1>传递请求参数</h1>
    <form action="request" method="post">
    	<input type="text" name="uname"/><br/>
    	<input type="password" name="pwd"/><br/>
    	<input type="checkbox" name="fav" value="a"/>巫山烤鱼
    	<input type="checkbox" name="fav" value="b"/>蒙古烤羊
    	<input type="checkbox" name="fav" value="c"/>全聚德<br/>
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>

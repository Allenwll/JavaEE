<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
  <h1>乱码处理</h1>
    <form action="charset" method="post">
    	用户名:<input type="text" name="name"><br/>
    	真  　名:<input type="text" name="realname"><br/>
    	 <input type="submit" value="提交">
    </form>
  </body>
</html>

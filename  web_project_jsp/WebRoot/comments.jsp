<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'comments.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <script type="text/javascript">
    //我是js注释
  </script>
  </head>
  
  <body>
   <h2>注释讲解</h2>
   <!-- 我是html注释 -->
    
    <%
    //我是java注释
    %>
    
    <%--我是66的jsp注释 --%>
    
    <%
    int girl=120;
    %>
    
  <%--   <!-- <%girl++;%>不能用html注释jsp代码--> --%>
  <%--推荐在jsp中使用jsp注释  --%>
   <%=girl %>
  </body>
</html>

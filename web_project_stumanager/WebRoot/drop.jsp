<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>删除</title>
  </head>
  
  <body>
   	<h2>删除学生</h2>
   	<form action="operator.action?method=delete" method="post">
   		学号:<input type="text" name="stuId" value="${param.id }"/><br/>
   		<input type="submit" value="删除"/>
   		
   	</form>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>注册页面</title>


</head>

<body>
	<h2>添加用户</h2>
	<form action="operator.action?method=register" method="post">
		姓名 :<input type="text" name="name"> <br /> 密码:<input
			type="password" name="password" /> <br /> <input type="submit"
			value="添加">
	</form>
	<br>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<title>首页</title>
</head>
<body>
	<form action="login.action">
		用户名：<input type="text" name="username"><br /> 密 码： <input
			type="text" name="password"> <br /> <input type="submit"
			value="登录" /> <select name="saveTime">
			<option value="366">一年</option>
			<option value="183">半年</option>
			<option value="30">一个月</option>
			<option value="7">一周</option>
		</select>
	</form>
</body>
</html>
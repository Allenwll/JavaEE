<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>添加学生</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body>
	<h2>添加学生</h2>
	<form action="operator.action?method=create" method="post">
		姓名 :<input type="text" name="name"> <br /> 年龄: <input
			type="text" name="age"> <br /> 成绩: <input type="text"
			name="score"> <br /> 班级:<select name="clazz">
			<option value="1">JavaOO1</option>
			<option value="2">AndroidOO1</option>
			<option value="3">IOSOO1</option>
			<br />
			<input type="submit" value="添加">
	</form>

</body>
</html>

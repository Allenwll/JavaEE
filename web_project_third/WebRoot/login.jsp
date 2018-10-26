<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jsp:include 动作实例</title>
</head>

<body>
	<!-- 定义form表单，接收输入的姓名和密码 -->
	<form action="loginReceive.jsp" name="form1" method="post">
		姓名:
		<!--接收输入的用户名，类型为文本类型，大小为12  -->
		<input type="text" name="userName" size="12" /><br /> 密码:
		<!--接收输入的密码，类型为密码，大小为12  -->
		<input type="password" name="password" size="12" /><br />
		<!--单击提交 ，跳转到action指向的loginReceive.jsp -->
		<input type="submit" name="Submit" value="提交" />
		<!--单击重置，触发Submit2，类型为reset，使已经输入的内容清空  -->
		<input type="reset" name="Submit2" value="重置" /><br />
	</form>
</body>
</html>

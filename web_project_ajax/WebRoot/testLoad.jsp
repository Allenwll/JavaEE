<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'testLoad.jsp' starting page</title>
<script type="text/javascript" src="script/jquery-3.1.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("a").click = this.href;
		var args = {
			"time" : new Date()
		};

		$("#main").load(url, args);
		return false;

	});
</script>

</head>

<body>
	<h1>学习jquery中的ajax</h1>
	<a href="hello.txt">jquery中ajax请求</a>
	<div id="main" style="width:300px;height:200px;border:1px solid red">
		NULL</div>
</body>
</html>

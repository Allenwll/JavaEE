<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		//顶部导航切换
		$(".nav li a").click(function() {
			$(".nav li a.selected").removeClass("selected")
			$(this).addClass("selected");
		})
	});
	function userOut() {
		var flag = window.confirm("亲，你真的要离开吗?");

		//判断
		if (flag) {
			//window.location="user.action?operate=out";//当前窗口页
			window.top.location = "user.action?operate=out";//整个窗口进行显示
		}
	}
</script>
</head>
<body style="background:url(images/topbg.gif) repeat-x;">
	<div class="topleft">
		<a href="main.jsp" target="_parent"><img src="images/logo.png"
			title="系统首页" /></a>
	</div>
	<div class="topright">
		<ul>
			<%--  <li><a href="login.jsp" target="_parent">退出</a></li>--%>
			<%--<li onclick="userOut();">退出</li>--%>
			<%--<li onclick="userOut();" style="cusor:pointer;">退出</li>--%>
			<li><a href="javascript:userOut();">退出</a></li>
		</ul>
		<div class="user">
			<span>${user.name}</span>
		</div>
	</div>
</body>
</html>

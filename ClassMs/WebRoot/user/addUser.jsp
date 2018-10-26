<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加用户</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("#uname")
				.blur(
						function() {
							var val = $("#uname").val();
							//去掉前后空格
							val = $.trim(val);
							if (val != "") {
								var url = "${pageContext.request.contextPath}/user.action?operate=check";
								var args = {
									"uname" : val,
									"time" : new Date()
								};//发送请求
								$.post(url, args, function(data) {
									$("#show").html(data);
								});

							} else {
								return;
							}
						});
	});
</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">新增用户</a></li>
		</ul>
	</div>
	<div class="formbody">
		<form action="user.action?operate=add" method="post">
			<div class="formtitle">
				<span>用户信息</span>
			</div>
			<ul class="forminfo">
				<li><label>用户名:</label><input name="uname" type="text"
					class="dfinput" id="uname" /><i id="show"></i></li>
				<li><label>密 码:</label><input name="pwd" type="text"
					class="dfinput" /><i>密码6-10个字符</i></li>
				<li><label>昵 称:</label><input name="nickname" type="text"
					class="dfinput" /><i>不能超过50个字符</i></li>
				<li><label>性 别:</label><cite><input name="sex"
						type="radio" value="1" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;<input
						name="sex" type="radio" value="0" />女</cite></li>
				<li><label>年 龄:</label><input name="age" type="text"
					class="dfinput" /><i>不能超过200岁</i></li>
				<li><label>爱 好:</label><input name="fav" type="text"
					class="dfinput" /><i>多个爱好用,隔开</i></li>

				<li><label>&nbsp;</label><input type="submit" class="btn"
					value="确认添加" /></li>
			</ul>
		</form>
	</div>
</body>
</html>

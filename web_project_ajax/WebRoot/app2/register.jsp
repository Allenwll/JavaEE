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

<title>注册页面</title>
<style type="text/css">
span {
	color: red;
}
</style>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/script/jquery-3.1.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("#uname")
				.change(
						function() {
							var val = $("#uname").val();
							//去掉前后空格
							val = $.trim(val);
							if (val != "") {
								var url = "${pageContext.request.contextPath}/checkUser.action";
								var args = {
									"uname" : val,
									"time" : new Date()
								};
								//发送请求
								$.get(url, args, function(data) {
									$("#message").html(data);
								});
							} else {
								return;
							}

						});
	});
</script>
</head>

<body>
	<h1>注册案例</h1>
	<br />
	<br />
	<hr />
	<form action="#" method="get">
		<table>

			<tr>
				<th>用户名:</th>
				<td><input type="text" name="uname" id="uname" maxlength="10" />
					<span id="message">*必填项*</span></td>
			</tr>
			<tr>
				<th>密 码:</th>
				<td><input type="password" name="pwd" id="pwd" maxlength="10"
					style="width: 147px; " /> <span>*必填项*</span></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="注册" /></td>
			</tr>
		</table>

	</form>
</body>
</html>

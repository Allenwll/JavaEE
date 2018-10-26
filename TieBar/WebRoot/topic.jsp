<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>发表帖子</title>

</head>

<body>
	<h3>发表帖子</h3>
	<form action="topic.action?method=create" method="post">
		<table>
			<tr>
				<th>作者:</th>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<th>标题:</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th style="vertical-align: top">内容:</th>
				<td><textarea rows="5" cols="30" name="content"></textarea></td>
			</tr>
			<tr>
				<th colspan="2" style="text-align: center;"><input
					type="submit" value="发表"></th>
			</tr>
		</table>
	</form>
</body>
</html>

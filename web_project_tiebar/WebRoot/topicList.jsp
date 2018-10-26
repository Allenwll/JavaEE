<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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

<title>贴吧主页</title>
<style type="text/css">
th {
	height: 25px;
	width: 400px;
	text-align: center;
	padding-bottom: 20px;
}

td {
	height: 25px;
	width: 400px;
	text-align: center;
	border-bottom: 1px solid #ccc;
}
</style>
</head>

<body style="margin-top:25px;">

	<a href="topic.jsp">我要发帖</a>
	<br />
	<br />
	<br />
	<table border="1">
		<tr>
			<th>标题</th>
			<th>发帖人</th>
			<th>发帖时间</th>
			<th>浏览量</th>
			<th>更多操作</th>

		</tr>
		<c:forEach var="topic" items="${list}">
			<tr>
				<td><a
					href="topic.action?method=detail&topic_id=${topic.topic_id}">${topic.title}</a></td>
				<td>${topic.author}</td>
				<td><fmt:formatDate value="${topic.create_time}"
						pattern="yyyy年-MM月-dd日 HH:mm:ss" /></td>
				</td>
				<td>${topic.click_amount}</td>
				<td><a
					href="topic.action?method=delete&topic_id=${topic.topic_id}"
					target="_self">删除该贴</a></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>

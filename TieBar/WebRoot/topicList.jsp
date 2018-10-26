<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">

<title>功能区</title>
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
	<table>
		<tr>

			<th>标 题</th>
			<th>发 帖 人</th>
			<th>发 帖 时 间</th>
			<th>浏 览 量</th>
			<th>更 多 操 作</th>
		</tr>
		<c:forEach var="topic" items="${list}">
			<tr>
				<td><a
					href="topic.action?method=detail&topicId=${topic.topicId }">${topic.title}</a></td>
				<td>${topic.author}</td>
				<td><fmt:formatDate value="${topic.createDate}"
						pattern="yyyy年-MM月-dd日 HH:mm:ss" /></td>
				<td>${topic.clickAmount}</td>
				<td><a
					href="topic.action?method=delete&topicId=${topic.topicId}">删除该贴</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>

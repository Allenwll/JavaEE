<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">

<title>详细信息</title>

</head>

<body style="text-align:center;">
	<h4>${topic.title }&nbsp;&nbsp;${topic.author}&nbsp;&nbsp;
		<fmt:formatDate value="${topic.create_time }" pattern="HH:mm:ss" />
		&nbsp; 共被浏览过 【${topic.click_amount}】次!
	</h4>
	<div>
		<span style="font-weight: bold">正文: </span> <span>${topic.content}
		</span>
		<hr />

		<span style="color:red">----------以下是评论区-------------</span> <br />
		<c:forEach items="${list}" var="reply">
			<br />
			昵称:${reply.author}　　时间:<fmt:formatDate value="${reply.create_time}"
				pattern="yyyy年-MM月-dd日 HH:mm：ss" />
		·<br />
			正文:
			<br />	${reply.content }
		</c:forEach>
		<hr />
	</div>
	<div align="center">
		<form action="reply.action?method=create" method="post">
			<input type="hidden" name="topic_id" value="${topic.topic_id}">
			<table>
				<tr>
					<td>昵称：</td>
					<td><input type="text" name="author"></td>
				</tr>
				<tr>
					<td style="vertical-align: top">评论:</td>
					<td><textarea rows="5" cols="25" name="content"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="发表"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>

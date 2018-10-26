<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>查询用户</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	text-align: center;
}

div {
	margin-top: 20px;
	margin-bottom: 10px;
}

font {
	color: #066C95;
	font-size: 20px;
	font-weight: bold;
}
</style>
<script type="text/javascript">
	//删除与否
	function userDel() {
		return window.confirm("亲，真的要删除吗?");
	}
</script>
</head>

<body>
	<div>
		<form action="user.action?operate=sel" method="post">
			<font>请输入姓或者名来进行模糊查询</font>&nbsp;&nbsp; <input type="text" name="sel"
				value="${sel}" class="dfinput"> <input type="submit" value="查询"
				class="btn">
		</form>
	</div>
	<table class="tablelist">
		<thead>
			<tr>
				<th><input name="" type="checkbox" value="" checked="checked" /></th>
				<th>编号<i class="sort"><img src="images/px.gif" /></i></th>
				<th>姓名</th>
				<th>密码</th>
				<th>昵称</th>
				<th>性别</th>
				<th>年龄</th>
				<th>爱好</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="u" items="${userList}">
				<tr>
					<td><input name="" type="checkbox" value="" /></td>
					<td>${u.id}</td>
					<td>${u.name }</td>
					<td>${u.pwd }</td>
					<td>${u.nickName }</td>
					<td>${u.sex==1?'男':'女' }</td>
					<td>${u.age }</td>
					<td>${u.fav }</td>
					<td><a
						href="user.action?operate=update&id=${u.id}&sel=${sel}&control=conUpdate"
						class="tablelink" target="rightFrame">修改</a> <a
						href="user.action?operate=delete&id=${u.id}&sel=${sel}&control=conDel"
						class="tablelink" onclick="return userDel();" target="rightFrame">删除</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="pagin">
		<div class="message">
			共<i class="blue">${total}</i>条记录,共<i class="blue">${count}</i>页，当前显示第&nbsp;<i
				class="blue">${num }&nbsp;</i>页
		</div>
		<ul class="paginList">
			<c:if test="${num!=1}">
				<li class="paginItem"><a
					href="user.action?operate=sel&num=${num-1}&sel=${sel}" target="rightFrame"><span
						class="pagepre"></span></a></li>
			</c:if>
			<c:forEach begin="1" end="${count}" var="i" step="1">
				<c:if test="${num==i}">
					<li class="paginItem current"><a
						href="user.action?operate=sel&num=${i}&sel=${sel}">${i}</a> <ser /li>
				</c:if>
				<c:if test="${num!=i}">
					<li class="paginItem"><a
						href="user.action?operate=sel&num=${i}&sel=${sel}" target="rightFrame">${i}</a></li>
				</c:if>

			</c:forEach>
			<c:if test="${num!=count}">
				<li class="paginItem"><a
					href="user.action?operate=sel&num=${num+1}&sel=${sel}" target="rightFrame"><span
						class="pagenxt"></span></a></li>
			</c:if>
		</ul>
	</div>
	<div class="tip">
		<div class="tiptop">
			<span>提示信息</span><a></a>
		</div>
		<div class="tipinfo">
			<span><img src="images/ticon.png" /></span>
			<div class="tipright">
				<p>是否确认对信息的修改 ？</p>
				<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
			</div>
		</div>
		<div class="tipbtn">
			<input name="" type="button" class="sure" value="确定" />&nbsp; <input
				name="" type="button" class="cancel" value="取消" />
		</div>
	</div>
</body>
</html>

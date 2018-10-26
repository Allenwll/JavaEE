<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>所有用户</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});
		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});
		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});
		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});
	});
	//删除与否
	function userDel() {
		return window.confirm("亲，真的要删除吗?");
	}
</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据表</a></li>
			<li><a href="#">基本内容</a></li>
		</ul>
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
						href="user.action?operate=update&id=${u.id}&control=norUpdate"
						class="tablelink" target="rightFrame">修改</a> <a
						href="user.action?operate=delete&id=${u.id}&control=norDel"
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
					href="user.action?operate=all&num=${num-1}" target="rightFrame"><span
						class="pagepre"></span></a></li>
			</c:if>
			<c:forEach begin="1" end="${count}" var="i" step="1">
				<c:if test="${num==i}">
					<li class="paginItem current"><a
						href="user.action?operate=all&num=${i}"  target="rightFrame">${i}</a> <ser /li>
				</c:if>
				<c:if test="${num!=i }">
					<li class="paginItem"><a
						href="user.action?operate=all&num=${i}"  target="rightFrame">${i}</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${num!=count}">
				<li class="paginItem"><a
					href="user.action?operate=all&num=${num+1}" target="rightFrame"><span
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

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>

<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>首页</title>
<%
	String name = request.getParameter("uname");
%>
<h1 align='center'>学生管理系统</h1>
<a href='add.jsp'>添加</a>
<span style="position: absolute ;right:10px;">当前用户:${myName}
	您是访问该网站的第${Count}个用户<a href="operator.action?method=logOut">注销</a>
</span>
<hr />
	<form action="operator.action?method=choiceQuery" method="post" style="text-align:center;">
	姓名<input type="text" name="name" value="${name}" /> 分数><input
		type="text" name="score"/> 班级<select name="clazz">
		<option value="-1">---不限---</option>
		<option value="1">JavaOO1</option>
		<option value="2">AndroidOO1</option>
		<option value="3">IOSOO1</option>
	</select> <input type="submit" value="提交" />
</form>
<hr />
<table width='80%' border='1' align="center">
	<tr>
		<th>编号</th>
		<th>姓名</th>
		<th>年龄</th>
		<th>分数</th>
		<th>班级编号</th>
		<th>班级名称</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${stuList}" var="student">
		<tr>
			<td>${student.id}</td>
			<td>${student.name }</td>
			<td>${student.age }</td>
			<td>${student.score }</td>
			<td>${student.clazz.classId}</td>
			<td>${student.clazz.className}</td>
			<th>&nbsp;&nbsp;<a href='update.jsp?id=${student.id}'>更新&nbsp;&nbsp;</a><a
				href='drop.jsp?id=${student.id}'>删除</a></th>
			<c:set var="sum" value="${sum+student.score}"></c:set>
			<c:set var="count" value="${count+1}"></c:set>
		</tr>
	</c:forEach>
	<tr>
		<th colspan='7'>总分：${sum} 人数：${count} 平均分：${sum/count}</th>
	</tr>
</table>
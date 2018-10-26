<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript">
	function chooseSex() {
		var sex = ${user.sex};

		if (sex == 1) {
			document.getElementById("man").checked = true;
		} else {
			document.getElementById("woman").checked = true;
		}

	}
</script>
</head>
<body onload="chooseSex();">
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">修改用户</a></li>
		</ul>
	</div>
	<div class="formbody">
		<form action="user.action?operate=updateUser" method="post">
			<input type="hidden" value=${sel } name="sel" /> <input
				type="hidden" value=${control} name="control" />
			<div class="formtitle">
				<span>用户信息</span>
			</div>
			<ul class="forminfo">
				<li><label>id:</label><input name="id" type="text"
					class="dfinput" readonly="readonly" value="${user.id}" /><i>不能超过50个字符</i></li>
				<li><label>用户名:</label><input name="uname" type="text"
					class="dfinput" value="${user.name }" /><i>不能超过50个字符</i></li>
				<li><label>密 码:</label><input name="pwd" type="text"
					class="dfinput" value="${user.pwd}" /><i>密码6-10个字符</i></li>
				<li><label>昵 称:</label><input name="nickname" type="text"
					class="dfinput" value="${user.nickName }" /><i>不能超过50个字符</i></li>
				<%-- 				<c:if test="${user.sex==1}">
					<li><label>性 别:</label><cite><input name="sex"
							type="radio" value="1" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;<input
							name="sex" type="radio" value="0" />女</cite></li>
				</c:if>
				<c:if test="${user.sex==0}">
					<li><label>性 别:</label><cite><input name="sex"
							type="radio" value="1"  />男&nbsp;&nbsp;&nbsp;&nbsp;<input
							name="sex" type="radio" value="0" checked="checked" />女</cite></li>
				</c:if>
				 --%>
				<li><label>性 别:</label><cite><input name="sex"
						type="radio" value="1" id="man" />男&nbsp;&nbsp;&nbsp;&nbsp;<input
						name="sex" type="radio" value="0" id="woman" />女</cite></li>
				<li><label>年 龄:</label><input name="age" type="text"
					class="dfinput" value="${user.age }" /><i>不能超过200岁</i></li>
				<li><label>爱 好:</label><input name="fav" type="text"
					class="dfinput" value="${user.fav }" /><i>多个爱好用,隔开</i></li>

				<li><label>&nbsp;</label><input type="submit" class="btn"
					value="确认修改" /></li>
			</ul>
		</form>
	</div>
</body>
</html>
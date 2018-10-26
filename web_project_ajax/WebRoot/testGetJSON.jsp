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

<title>getJSON</title>

<script type="text/javascript" src="script/jquery-3.1.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("a").click(function() {
			var url = this.href;
			var args = {"time" : new Date()};
			$.getJSON(url,args,function(data){
				var name=data.person.name;
				var website=data.person.website;
				var email=data.person.email;
				//进行页面展示
					$("#main").empty().append(
								"<h2><a href="+website+">" + name
										+ "</a></h2><a href="+website+">"
										+ email + "</a>");
					},"JSON");
					return false;
			});

		});
	});
</script>
</head>

<body>
	<h2>JSON的数据交互格式</h2>
	<ol>
		<li><a href="file/andy.json">Andy json</a></li>
		<li><a href="file/kitty.json">kitty json</a></li>
		<li><a href="file/tony.json">tony json</a></li>
	</ol>
	<div id="main" style="width:300px;height:200px;border:1px solid red">
		NULL</div>
</body>
</html>

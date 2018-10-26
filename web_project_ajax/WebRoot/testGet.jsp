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

<title>My JSP 'testGet.jsp' starting page</title>

<script type="text/javascript" src="script/jquery-3.1.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("a").click(
				function() {
					var url = this.href;
					var args = {"time" : new Date()};
					$.get(url, args, function(data) {
						//进行显示                                                      
						var name = $(data).find("name").text();
						var website = $(data).find("website").text();
						var email = $(data).find("email").text();
						alert(name);
						$("#main").empty().append(
								"<h2><a href="+website+">" + name
										+ "</a></h2><a href="+website+">"
										+ email + "</a>");
					});
					return false;
				});
	});
</script>

</head>

<body>
	This is my JSP page.
	<br>
</body>
</html>

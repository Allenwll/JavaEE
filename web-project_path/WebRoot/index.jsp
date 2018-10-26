<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'aaa.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<h3>路径讲解</h3>
	<h2>服务器根路径：webapps/:-----http://localhost:8080/</h2>
	<h2>项目根路径：webPath/----:http://localhost:8080/webPath/</h2>
	<h4>相对路径和绝对路径</h4>
	<h4>相对路径(1.查找路径麻烦 2.不能移动文件)</h4>
	<ol>
		<li><a href="">当前路径</a></li>
		<li><a href="a/a.jsp">a.jsp</a></li>
		<li><a href="b/b.jsp">b.jsp</a></li>
		<li><a href="a/aa/aaa/aaaa/aaaa.jsp">aaaa.jsp</a></li>
	</ol>
	<h4>绝对路径[使用加 “/”](1.项目名不能更改，一旦更改，路径失效)</h4>
	<ol>
		<li><a href="/">当前路径</a></li>
		<li><a href="/webPath/a/a.jsp">a.jsp</a></li>
		<li><a href="/webPath/b/b.jsp">b.jsp</a></li>
		<li><a href="/webPath/a/aa/aaa/aaaa/aaaa.jsp">aaaa.jsp</a></li>
	</ol>
	<h4>servlet(url-pattern: 默认指向项目根路径)</h4>
	<ol>

		<li>跳转----绝对路径----请求转发----指向项目根路径: webPath</li>
		<li>跳转----绝对路径----重定向----指向服务器根路径: localhost:8080</li>
	</ol>

	<h2>总结：----解决路径不合理的办法</h2>
	<ol>
		<li>JSP:用head中的base标签
			<base href="">
		</li>
		<li>Servlet绝对路径: 用 resp.sendRedirect(req.getContextPath（）)</li>
	</ol>


</body>
</html>

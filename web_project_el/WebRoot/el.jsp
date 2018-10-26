<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="allen.bean.User"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>El表达式</title>

</head>

<body>
	<h2>El:取代JSP中的Java代码</h2>
	<h2>El:能从作用域中取值</h2>
	<h2>El:能获取请求参数</h2>
	<ol>
		<li><%=request.getParameter("uname")%></li>
		<li><%=request.getParameter("pwd")%></li>
		<li><%=request.getParameterValues("fav")[0]%></li>
		<li><%=request.getAttribute("realname")%></li>
		<li><%=(List<String>) request.getAttribute("list")%></li>
		<li><%=((Map<String, String>) request.getAttribute("map"))
					.get("y")%></li>
		<li><%=(User) request.getAttribute("user")%></li>
		<li><%=(List<User>) request.getAttribute("userList")%></li>
		<li><%=((List<User>) request.getAttribute("userList")).get(1)
					.getAddr().getCounty()%></li>
		<li><%=(Map<String, User>) request.getAttribute("userMap")%></li>
		<li><%=((Map<String, User>) request.getAttribute("userMap"))
					.get("c").getAddr().getCounty()%></li>
	</ol>
	<hr />

	<h3>El表达式</h3>
	<ol>
		<h4>获取请求参数</h4>
		<li>${param.uname}</li>
		<li>${param.pwd}</li>
		<li>${paramValues.fav[0]}</li>
		<h4>获取作用域的值</h4>
		<li>${realname}</li>
		<h4>获取作用域中容器的值</h4>
		<li>${list}</li>
		<li>${list[1]}</li>
		<li>${map}</li>
		<li>${map.y}</li>
		<h4>获取作用域中对象的值</h4>
		<li>${user}</li>
		<h4>获取作用域中容器中的对象的值:通过反射找到对应属性的值的获取方法</h4>
		<li>${userList[1].addr.county}</li>
		<li>${mapList.c.addr.county}</li>



	</ol>
</body>
</html>

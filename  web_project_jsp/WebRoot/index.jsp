<%@page import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8"%>

<h3>为什么要用JSP</h3>
<h3>为什么说JSP本质上是Servlet</h3>
<h3>JSPd执行过程</h3>

<h1>
	Welcome
	<%=UUID.randomUUID().toString()%></h1>

<%
	int num = 100;
	if (num == 100) {
		System.out.print("相等!");
%>
相等
<%
	} else {
		System.out.print("不相等!");
%>
不相等
<%
	}
%>
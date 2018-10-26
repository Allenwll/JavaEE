<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	pageContext.setAttribute("hello", "pageContext");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>EL表达式的学习</title>

</head>

<body>

	<h2>EL表达式的学习</h2>
	<h4>EL从作用取值的取值顺序------从小到大</h4>
	${hello}-----------------
	<h4>EL跨作用域取值</h4>
	${pageScope.hello}-----${requestScope.hello}--------${sessionScope.hello}-------${applicationScope.hello}
	<h4>EL表达式不能操作局部变量</h4>

	<h4>空的判断</h4>
	${empty el }--- ${empty e2 }--- ${empty e3 }--- ${empty e4 }

	<h4>.与[]的区别------.简答方便</h4>

	${user.realname}-----${user["realname"] }

	<h4>逻辑运算:＋只能进行算术运算，不能进行字符串拼接</h4>

	${4+5}---${3*3 }---${1/0}-----Infinity----${"3"+"3"}---	${3==4 ? "Yes" : "No" }
	
	<h4>如果作用域中没有设置该值的话，不会报错，也不会进行输出</h4>
	${lulu}++++

</body>
</html>

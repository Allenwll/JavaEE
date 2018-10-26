<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.bjsxt.com/sxtfunctions" prefix="sxt"%>

<%
	String str = "   sssss    s";
	String str1 = "a   sssss   ";
	request.setAttribute("str", str);
	request.setAttribute("str1", str1);
%>
<html>
<head>


<title>自定义标签库</title>

</head>

<body>
	<h2>自定义函数库</h2>
	<ol>

		<li>在/WeebRoot/WEB-INF下新建一个tld文件</li>
		<li>找到jstl-1.2.jar----MATE-INF---fn.tld将里面的内容复制到自己新建的tld文件中</li>
		<li>根据需求自己修改</li>
	</ol>
	${sxt:ltrim(str)} ${sxt:Rtrim(str1)}
	<br>
</body>
</html>

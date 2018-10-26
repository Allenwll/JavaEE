<%@ page contentType="text/html; charset=utf-8"
	errorPage="errorPageDirec.jsp"%>

<html>
<head>
<title>page指令实例</title>
<body>
	<%
		int a = 10;
		int b = a / 0;
		out.println(b);
	%>
</body>
</html>

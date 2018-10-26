<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
	String str = "I am Your Father!";

	request.setAttribute("str", str);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


</head>

<body>
	<h1>fns库的学习</h1>

	----${fn:toUpperCase(str)}----${fn:length(str) }

</body>
</html>

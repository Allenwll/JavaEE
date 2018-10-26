<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'fmt.jsp' starting page</title>

</head>

<body>
	<h1>fmt库的学习</h1>
	<fmt:formatDate value="${myTime}" pattern="yyyy年MM月dd日HH:mm:ss" />
	<fmt:formatNumber value="123456.78" pattern="$##,###,###.##"></fmt:formatNumber>
	<fmt:formatNumber value="123456.78"pattern="￥##,###,###.##"></fmt:formatNumber>
</body>
</html>

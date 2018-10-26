<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Import</title>


</head>

<body>
	My Page
	<br>

	<c:import url="www.baidu.com" var="baidu" charEncoding="utf-8"></c:import>
	${baidu}
	

</body>
</html>

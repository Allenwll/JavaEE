<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <base href="<%=basePath%>">
<title>尾部</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="footer">
    <span>餐风饮露</span>
    <i>&copy;版权所有Allen 切勿用于商业用途</i>    
    </div>    
</body>
</html>
    
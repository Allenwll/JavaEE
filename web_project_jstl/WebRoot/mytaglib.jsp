<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.bjsxt.com/jsp/sttaglib" prefix="st"%>


<%
	/*定义用户使用权限  */
	session.setAttribute("upower", (int) (Math.random() * 9));
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>自定义标签库</title>
</head>

<body>
	<h1>自定义标签库</h1>
	<ol>
		<li>在/WeebRoot/WEB-INF下新建一个tld文件</li>
		<li>找到jstl-1.2.jar----MATE-INF---core.tld将里面的内容复制到自己新建的tld文件中</li>
		<li>创建一个普通java类，继承TagSupport</li>
		<li>一般重写2个方法: doStartTag(),doEndTag()</li>
	</ol>


	<h3>您当前的权限是${upower}</h3>
	<st:check lowPower="1">
		<input type="button" value="查询1">
	</st:check>
	<st:check lowPower="3">
		<input type="button" value="新增3">
	</st:check>
	<st:check lowPower="5">
		<input type="button" value="修改5">
	</st:check>
	<st:check lowPower="7">
		<input type="button" value="删除7">
	</st:check>
</body>
</html>

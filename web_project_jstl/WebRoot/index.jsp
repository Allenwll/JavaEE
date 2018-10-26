<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>JSTL学习</title>

</head>

<body>

	<h3>JSTL的学习----------使用前必须导包lib</h3>

	<ol>

		<li>core</li>
		<li>fmt</li>
		<li>functions</li>
		<li>xml</li>
		<li>sql</li>
	</ol>

	<h3>set/get/remove</h3>

	<!-- 获取值 -->
	<c:out value="${hello} " default="默认值"></c:out>

	<!-- 设置值 -->
	<c:set var="hi" value="Flower"></c:set>
	----${hi}
	<c:set var="xiwa" value="pageContext" scope="page"></c:set>
	<c:set var="xiwa" value="request" scope="request"></c:set>
	<c:set var="xiwa" value="session" scope="session"></c:set>
	<c:set var="xiwa" value="request" scope="application"></c:set>
	<br />
	----${xiwa}----${requestScope.xiwa}---${sessionScope.xiwa}---${applicationScope.xiwa}

	<br />
	<c:remove var="xiwa" scope="session" />
	----${xiwa}----${requestScope.xiwa}---${sessionScope.xiwa}---${applicationScope.xiwa}

	<h4>分支处理</h4>

	<c:if test="true">
	二是二
	</c:if>

	<h4>多分支</h4>

	<c:choose>

		<c:when test="${score>90 }">
	优秀
		</c:when>

		<c:when test="${score>80 }">
	
		良好
		</c:when>

		<c:when test="${score>60}">
		合格
		</c:when>

		<c:otherwise>
			男女混合双打
		</c:otherwise>
	</c:choose>

	<h3>九九乘法表</h3>
	<c:forEach begin="1" end="9" var="i">
		<c:forEach begin="1" end="${i}" var="j">
			
			${i}*${j}=${i*j}&nbsp;&nbsp;
			
		</c:forEach>
		<br>
	</c:forEach>

	<h3>循环获取容器内的值</h3>
	<c:forEach items="${list}" var="i" step="2" varStatus="j">
	
	
		${i}----${j.first}----${j.last}-----${j.index}<br />

	</c:forEach>


	<c:forEach items="${map}" var="i">
	 ${i}----${i.key}----${i.value}<br>

	</c:forEach>

</body>
</html>

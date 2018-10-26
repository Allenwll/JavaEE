<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<head>
<title>Go购电子商城后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../CSS/style.css" rel="stylesheet">
</head>

<body>
	<table width="777" height="192" border="0" align="center"
		cellpadding="0" cellspacing="0" class="tableBorder">
		<tr>
			<td><jsp:include page="banner.jsp" />
				<table width="777" height="288" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<tr>
						<td width="182" valign="top"><table width="100%" height="431"
								border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="top" background="../images/manage_02.gif"><jsp:include
											page="navigation.jsp" /></td>
								</tr>
							</table></td>
						<td align="center" valign="top"><table width="100%"
								height="120" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="top" background="../images/manage_03.gif"><table
											width="100%" height="36" border="0" cellpadding="0"
											cellspacing="0">
											<tr>
												<td width="98%" align="right"><a
													href="../M_SeleSuperServlet?action=sele">[ <img
														src="../images/list.gif" width="11" height="13">&nbsp;大分类信息管理]
												</a>&nbsp;<a href="../M_SeleSubServlet?action=sele">[ <img
														src="../images/list.gif" width="11" height="13">&nbsp;小分类信息管理]
												</a>&nbsp;<a
													href="<%=basePath%>manage/goodsServlet?action=toSave">[
														<img src="../images/list.gif" width="11" height="13">&nbsp;添加商品信息]
												</a></td>
												<td width="2%">&nbsp;</td>
											</tr>
										</table></td>
								</tr>
							</table>
							<table width="92%" height="192" border="0" cellpadding="0"
								cellspacing="0">
								<tr>
									<td valign="top">
										<table width="100%" height="14" border="0" cellpadding="0"
											cellspacing="0">
											<tr>
												<td height="13" align="center">&nbsp;</td>
											</tr>
										</table>
										<table width="100%" height="48" border="1" cellpadding="0"
											cellspacing="0" bordercolor="#FFFFFF"
											bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF">
											<tr bgcolor="#eeeeee">
												<td width="22%" height="24" align="center">商品名称</td>
												<td width="40%" align="center">简介</td>
												<td width="11%" align="center">是否新品</td>
												<td width="11%" align="center">是否特价</td>
												<td width="8%" align="center">修改</td>
												<td width="8%" align="center">删除</td>
											</tr>
											<c:forEach items="${list }" var="goods">
												<tr style="padding:5px;">
													<td height="20" align="center">${goods.goodsName}
														nihao</td>
													<td align="center">${goods.introduce }</td>
													<c:if test="${goods.newGoods==1}">
														<td align="center">是</td>
													</c:if>
													<c:if test="${goods.newGoods==0}">
														<td align="center">否</td>
													</c:if>
													<c:if test="${goods.sale==1}">
														<td align="center">是</td>
													</c:if>
													<c:if test="${goods.sale==0}">
														<td align="center">否</td>
													</c:if>
													<td align="center"><a
														href="<%=basePath %>manage/goodsServlet?action=toUpdate&goods_id=${goods.id }"><img
															src="../images/modify.gif" width="15" height="15"></a></td>
													<td align="center"><a
														href="<%=basePath %>manage/goodsServlet?action=delete&goods_id=${goods.id }"><img
															src="../images/del.gif" width="16" height="16"></a></td>
												</tr>
											</c:forEach>
										</table>
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td align="right">当前页数：[${num }/${count }]&nbsp; <a
													href="<%=basePath%>manage/goodsServlet?action=queryPage&pageNum=1&pageSize=5">第一页</a>

													<c:if test="${num - 1 < 1}">
														<a href="../GoodsPageServlet?Page=1">上一页</a>
													</c:if> <c:if test="${num - 1 >= 1}">
														<a
															href="<%=basePath %>manage/goodsServlet?action=queryPage&pageNum=${num - 1}&pageSize=5">上一页</a>
													</c:if> <c:if test="${num + 1 <= count }">
														<a
															href="<%=basePath %>manage/goodsServlet?action=queryPage&pageNum=${num + 1}&pageSize=5">下一页</a>
													</c:if> <c:if test="${num + 1 > count }">
														<a
															href="<%=basePath %>manage/goodsServlet?action=queryPage&pageNum=${count}&pageSize=5">下一页</a>
													</c:if> <a
													href="<%=basePath %>manage/goodsServlet?action=queryPage&pageNum=${count}&pageSize=5">最后一页&nbsp;</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<table width="100%" height="46" border="0" cellpadding="0"
								cellspacing="0">
								<tr>
									<td background="../images/manage_06.gif">&nbsp;</td>
								</tr>
							</table></td>
					</tr>
				</table>
				<table width="777" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="54" align="center"><jsp:include
								page="copyright.jsp" /></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>

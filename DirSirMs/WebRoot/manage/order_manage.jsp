<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Go购电子商城后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../CSS/style.css" rel="stylesheet">
</head>

<body  onLoad="clockon(bgclock)">  
<table width="777" height="192"  border="0" align="center" cellpadding="0" cellspacing="0" class="tableBorder">
<tr>
  <td>
<jsp:include page="banner.jsp"/>
<table width="777" height="288"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="182" valign="top"><table width="100%" height="431"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="../images/manage_02.gif"><jsp:include page="navigation.jsp"/></td>
      </tr>
    </table></td>
    <td align="center" valign="top"><table width="100%" height="120"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="../images/manage_center_orderlist.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="98%" align="right">&nbsp;</td>
            <td width="2%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="95%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
         
<table width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF">
                    <tr align="center">
                      <td width="8%" height="30">订单号</td>
                      <td width="10%">品种数</td>
                      <td width="10%">真实姓名</td>
                      <td width="15%">付款方式</td>
                      <td width="17%">运送方式</td>
                      <td width="6%">折扣</td>
                      <td width="26%">订货日期</td>
                      <td width="10%">执行</td>
                    </tr>
<c:forEach items="${order}" var="ord" > 
		<tr align="center">
		
		  <td height="24"><a href="../M_orderDetailServlet?ID=${ord.orderid }">${ord.orderid }</a></td>
		   <input name="ID" type="hidden" value="1"> 
		  <td>${ord.bnumber }</td>
		  <td>${ord.truename }</td>
		  
		  <td>${ord.pay }</td>
		  <td>${ord.carray }</td>
		  <td>${ord.rebate }</td>
		  <td>${ord.orderdate }</td>
		  <c:if test="${ord.enforce==0}">
		  <td><a href="../M_EnforceServlet?ID=${ord.orderid }&enforce=1"><img src="../images/enforce.gif" width="16" height="16"></a>
		  未执行</td>
		  </c:if>
		  <c:if test="${ord.enforce!=0}">
		   <td><img src="../images/enforce.gif" width="16" height="16"> 已执行</td>
		  </c:if>
		</tr>
  </c:forEach>
            </table>
           
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
 
    <td height="24" align="right">当前页数：[${nowpage }/${lastpage }]&nbsp;
	
	<a href="../PageServlet?Page=1">第一页</a>　
	
	<c:if test="${previouspage<1}">
	 <a href="../PageServlet?Page=1">上一页</a> 
	</c:if>
	<c:if test="${previouspage>=1}">
	<a href="../PageServlet?Page=${previouspage}">上一页</a> 
	</c:if>
	<a href="../PageServlet?Page=${nextpage}">下一页</a>
	<a href="../PageServlet?Page=${lastpage }">最后一页&nbsp;</a>
	</td>
  </tr>
</table>		  </td>
        </tr>
      </table>
      <table width="100%" height="46"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td background="../images/manage_06.gif">&nbsp;</td>
        </tr>
      </table></td>
  </tr>
</table>
<table width="777"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="54" align="center"><jsp:include page="copyright.jsp"/></td>
  </tr>
</table>
</td>
</tr>
</table>
</body>
</html>

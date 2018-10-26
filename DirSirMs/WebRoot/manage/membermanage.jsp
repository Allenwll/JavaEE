<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
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
        <td valign="top" background="../images/manage_center_memberlist.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="98%" align="right">&nbsp;</td>
            <td width="2%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
<table width="100%" height="14"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="13" align="center">&nbsp;</td>
            </tr>
          </table>
            <table width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF">
              <tr>
                <td width="14%" height="27" align="center">用户名</td>
                <td width="14%" align="center">真实姓名</td>
                <td width="10%" align="center">城市</td>
                <td width="14%" align="center">电话</td>
                <td width="26%" align="center">Email</td>
                <td width="10%" align="center">销费额</td>
                <td width="12%" align="center">冻结/解冻</td>
              </tr>

        <c:forEach items="${member}" var="mem">
              <tr style="padding:5px;">
                <td height="24" align="center"><a href="../M_SeleMemberServlet?action=selectById&ID=${mem.id }">${mem.username }</a></td>
                <td align="center">${mem.truename }</td>
                <td align="center">${mem.city }</td>
                <td align="center">${mem.tel }</td>
                <td align="center">${mem.email }</td>
                <td align="center">${mem.amount }</td>
                <td align="center">
                <c:if test="${mem.freeze==0}">
                <a href="../M_SeleMemberServlet?action=update&ID=${mem.id }&freeze=1"><img src="../images/freeze.gif" alt="冻结" width="13" height="15"></a>
               </c:if>
                <c:if test="${mem.freeze==1}">
				<a href="../M_SeleMemberServlet?action=update&ID=${mem.id }&freeze=0"><img src="../images/thaw.gif" alt="解冻" width="15" height="15"></a>
					</c:if>		</td>
              </tr>
      </c:forEach>
            </table>
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="27" align="right">当前页数：[${nowpage }/${lastpage }]&nbsp;
	
	<a href="../MemPageServlet?Page=1">第一页</a>　
	<c:if test="${previouspage<1}">
	<a href="../MemPageServlet?Page=1">上一页</a>
	</c:if>
	<c:if test="${previouspage>=1}">
	<a href="../MemPageServlet?Page=${previouspage }">上一页</a>
	</c:if>
	　<a href="../MemPageServlet?Page=${nextpage }">下一页</a>　<a href="../MemPageServlet?Page=${lastpage }">最后一页&nbsp;</a>
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

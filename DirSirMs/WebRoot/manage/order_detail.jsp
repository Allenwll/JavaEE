<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Go购电子商城后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../CSS/style.css" rel="stylesheet">
<script src="onclock.JS"></script>
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
        <td valign="top" background="../images/manage_center_orderdetail.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
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
<table width="100%" height="272"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="97%" height="220" align="center" valign="top">
             
					  <table width="90%" height="131"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_LTR_dashed">
                        <tr>
                          <td width="16%" style="padding:5px;">订 单 号：&nbsp;${orderd.orderid }</td>
                          </tr>
                          
                        <tr>
                          <td style="padding:5px;">地&nbsp;&nbsp;&nbsp;&nbsp;址：&nbsp;${orderd.address }</td>
                          </tr>
                        <tr>
                          <td style="padding:5px;">邮政编码：&nbsp;${orderd.postcode }</td>
                          </tr>
                        <tr>
                          <td style="padding:5px;">电&nbsp;&nbsp;&nbsp;&nbsp;话：&nbsp;${orderd.tel }</td>
                          </tr>
                        <tr>
                          <td style="padding:5px;">备&nbsp;&nbsp;&nbsp;&nbsp;注：&nbsp;${orderd.bz }</td>
                        </tr>
                      </table>
                      
					  <table width="90%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#CCCCCC" class="tableBorder_dashed">
                        <tr align="center" bgcolor="#eeeeee">
                          <td width="21%" height="24">商品号</td>
                          <td width="45%">商品名称</td>
                          <td width="22%">单价</td>
                          <td width="12%">数量</td>
                          </tr>
					<c:forEach items="${goodss}" var="good">
                        <tr align="center">
                          <td height="27">${good.goodsid }</td>
                          <td height="27">${good.goodsname }</td>
                          <td>${good.price }(元)</td>
                          <td>${good.number }</td>
                          </tr>
						</c:forEach>
                      </table>
                      
					  <table width="100%" height="49"  border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td align="center"><input name="Submit" type="submit" class="btn_grey" value="返回" onClick="history.back(-1)"></td>
                        </tr>
                      </table></td>
              <td width="3%" valign="top">&nbsp;</td>
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

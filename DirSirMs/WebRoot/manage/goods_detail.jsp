<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
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
        <td valign="top" background="../images/manage_center_goodsdetail.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="98%" align="right"><a href="../M_SeleSuperServlet?action=sele">[ <img src="../images/list.gif" width="11" height="13">&nbsp;大分类信息管理]</a>&nbsp;<a href="../M_SeleSubServlet?action=sele">[ <img src="../images/list.gif" width="11" height="13">&nbsp;小分类信息管理]</a>&nbsp;<a href="goods_add.jsp">[ <img src="../images/list.gif" width="11" height="13">&nbsp;添加商品信息]</a></td>
            <td width="2%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
         
<table width="98%" height="79"  border="0" cellpadding="0" cellspacing="0" class="noborder">
                    
                     <tr>
                     <td width="37%" height="95" rowspan="4" align="center"><img src="<%=basePath %>${goods.picture }" width="210" height="198"></td>
                      <td width="63%">商品名称:${goods.goodsName }</td>
                    </tr>
                    <tr>
                      <td>单价:${goods.price }(元) </td>
                    </tr>
                    <tr>
                      <td>简介:${goods.introduce }</td>
                    </tr>
                    
                    <tr>
                      <td><input name="Submit" type="submit" class="btn_grey" onClick="history.back(-1);" value="返回">
&nbsp;					  &nbsp;
						
						 </td>
                    </tr>
                  
                  </table>	
                    	  </td>
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
<img src="<%=request.getContextPath() %>/image/${gdetail.picture }" width="210" height="198"/>
 
</body>
</html>

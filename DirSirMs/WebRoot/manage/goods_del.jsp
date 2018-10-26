<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Go购电子商城后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../CSS/style.css" rel="stylesheet">
</head>
<body>
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
        <td valign="top" background="../images/manage_center_goodsdel.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="98%" align="right"><a href="superType.jsp">[ <img src="../images/list.gif" width="11" height="13">&nbsp;大分类信息管理]</a>&nbsp;<a href="subType.jsp">[ <img src="../images/list.gif" width="11" height="13">&nbsp;小分类信息管理]</a>&nbsp;<a href="goods_add.jsp">[ <img src="../images/list.gif" width="11" height="13">&nbsp;添加商品信息]</a></td>
            <td width="2%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
   			 <form action="../M_SeleDeaServlet?action=delete" method="post" name="form1">
			    <table width="100%"  border="0" align="center" cellpadding="-2" cellspacing="-2" bordercolordark="#FFFFFF">
                  <tr>
                    <td width="20%" height="27">&nbsp;商品名称：</td>
                    <td height="27" colspan="3">&nbsp;${deat.goodsname }
					<input name="ID" type="hidden" id="ID" value="${deat.id }">
                      
                      &nbsp;&nbsp;                    </td>
                    </tr>
                  <tr>
                    <td width="20%" height="27">&nbsp;所属大类：</td>
                    <td width="31%" height="27">&nbsp;${ss.supername }</td>
                    <td width="20%" height="27"> &nbsp;所属小类：</td>
                    <td width="42%" height="27">&nbsp;${ss.subname }</td>
                  </tr>
                  <tr>
                    <td height="16" width="20%">&nbsp;图片文件：</td>
                    <td height="27" colspan="3">&nbsp;
                      ${deat.picture }</td>
                    </tr>
                  <tr>
                    <td height="27"width="20%" align="center">定　　价：</td>
                    <td height="27" >&nbsp;${deat.price }(元)</td>
                    <td height="27" align="center">现&nbsp;&nbsp;&nbsp;&nbsp;价： </td>
                    <td height="27">&nbsp;${deat.nowprice }(元)</td>
                  </tr>
                  <tr>
                    <td height="45"width="20%">&nbsp;是否新品：</td>
                    <c:if test="${deat.newgoods==1 }">
                    <td>&nbsp;是 </td>
                    </c:if>
                    <c:if test="${deat.newgoods==0 }">
                    <td>&nbsp;否 </td>
                    </c:if>
                    
                    <td width="20%">&nbsp;是否特价：</td>
                    <c:if test="${deat.sale==1 }">
                    <td>是</td>
                    </c:if>
                    <c:if test="${deat.sale==0 }">
                    <td>否</td>
                    </c:if>
                  </tr>
                  <tr>
                    <td width="20%" height="103">&nbsp;商品简介：</td>
                    <td colspan="3"><span class="style5">&nbsp;${deat.introduce } </span>
                       </td>
                  </tr>
                  <tr>
                    <td height="38" colspan="4" align="center">
                        <input name="Submit" type="submit" class="btn_grey" value="确定删除">
                        &nbsp;
                        <input name="Submit3" type="button" class="btn_grey" value="返回" onClick="JScript:history.back()">                    </td>
                  </tr>
                </table>
			  </form>
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
</body>
</html>

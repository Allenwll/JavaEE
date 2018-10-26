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
        <td valign="top" background="../images/manage_center_memberdetail.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
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
             <table width="96%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tableBorder_dashed">
                  <tr>
                    <td width="19%" height="27" align="center" class="tableBorder_B_dashed">&nbsp;用 户 名：</td>
                    <td height="13" class="tableBorder_B_dashed"> &nbsp;${detail.username }                  </td>
                    </tr>
                  <tr>
                    <td height="27" align="center" class="tableBorder_B_dashed">&nbsp;真实姓名：</td>
                    <td height="14" class="tableBorder_B_dashed">&nbsp;${detail.truename }</td>
                    </tr>
                  <tr>
                    <td height="27" align="center" class="tableBorder_B_dashed">&nbsp;城&nbsp;&nbsp;&nbsp;&nbsp;市：</td>
                    <td class="tableBorder_B_dashed">&nbsp;${detail.city }
                    </td>
                    </tr>
                  <tr>
                    <td height="27" align="center" class="tableBorder_B_dashed">&nbsp;地&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
                    <td height="14" class="tableBorder_B_dashed">&nbsp;${detail.address }</td>
                    </tr>
                  <tr>
                    <td height="27" align="center" class="tableBorder_B_dashed">&nbsp;邮政编码：</td>
                    <td width="81%" height="27" class="tableBorder_B_dashed">&nbsp;${detail.postcode }
                    </td>
                    </tr>
                  <tr>
                    <td height="27" align="center" class="tableBorder_B_dashed">&nbsp;证件类型：</td>
                    <td height="14" class="tableBorder_B_dashed">&nbsp;${detail.cardtype } </td>
                    </tr>
                  <tr>
                    <td height="27" align="center" class="tableBorder_B_dashed">&nbsp;证件号码：</td>
                    <td class="tableBorder_B_dashed">&nbsp;${detail.cardno }
                    </td>
                    </tr>
                  <tr>
                    <td height="27" align="center" class="tableBorder_B_dashed">&nbsp;电&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
                    <td class="tableBorder_B_dashed">&nbsp;${detail.tel }</td>
                    </tr>
                  <tr>
                    <td height="27" align="center" class="tableBorder_B_dashed">&nbsp;Email：</td>
                    <td class="tableBorder_B_dashed">&nbsp;${detail.email }</td>
                    </tr>
                  <tr>
                    <td height="27" align="center" class="tableBorder_B_dashed">&nbsp;消 费 额：</td>
                    <td class="tableBorder_B_dashed">&nbsp;${detail.amount }(元)</td>
                    </tr>
                  <tr>
                    <td height="38" colspan="2" align="center">

                        <input name="Submit3" type="button" class="btn_grey" value="返回" onClick="JScript:history.back()">                    </td>
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

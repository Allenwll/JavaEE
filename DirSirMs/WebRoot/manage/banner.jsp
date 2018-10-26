<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<script src="<%=basePath %>manage/onclock.js"></script>
<table width="777" height="115"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td bgcolor="#CCCCCC" height="6px"></td>
      </tr>
    </table>
      <table width="100%" height="123"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top" background="../images/manage_01.gif"><table width="100%" height="118"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="98" colspan="2">&nbsp;</td>
            </tr>
            <tr>
              <td width="25%">&nbsp;</td>
              <td width="75%" class="word_green" id="bgclock"></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
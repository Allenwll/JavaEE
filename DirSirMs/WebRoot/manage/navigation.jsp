<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<table width="100%" height="301"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="18%" height="61">&nbsp;</td>
            <td width="82%">&nbsp;</td>
          </tr>
          <tr>
            <td height="46">&nbsp;</td>
            <td><a href="../m_LoginServlet?action=glist" class="word_white">商品管理<br>
              Goods Manage</a></td>
          </tr>
          <tr>
            <td height="47">&nbsp;</td>
            <td><a href="../M_SeleMemberServlet?action=sele" class="word_white">会员管理<br>
              Member Manage</a></td>
          </tr>
          <tr>
            <td height="48">&nbsp;</td>
            <td><a href="../M_SelectOrderServlet?action=sele" class="word_white">订单管理<br>
              Order Manage</a></td>
          </tr>
          <tr>
            <td height="50">&nbsp;</td>
            <td><a href="../M_SelectBbsServlet?action=sele" class="word_white">公告管理<br>
               Manage Placard</a></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><a href="<%=basePath %>manage/managerServlet?action=exit" class="word_white">退出后台<br>
              Exit Background </a></td>
          </tr>
        </table>

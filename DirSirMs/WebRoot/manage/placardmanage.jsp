<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Go购电子商城后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../CSS/style.css" rel="stylesheet">
<script src="../JS/check.jsp"></script>
<script src="onclock.JS"></script>
</head>
<body  onLoad="clockon(bgclock)">  
<table width="777" height="192"  border="0" align="center" cellpadding="0" cellspacing="0" class="tableBorder"> 
  <tr> 
    <td> <table width="777" height="115"  border="0" align="center" cellpadding="0" cellspacing="0"> 
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
                      <td width="75%" class="word_green" id="bgclock"> </td> 
                    </tr> 
                  </table></td> 
              </tr> 
            </table></td> 
        </tr> 
      </table> 
      <table width="777" height="288"  border="0" align="center" cellpadding="0" cellspacing="0"> 
        <tr> 
          <td width="182" valign="top"><table width="100%" height="431"  border="0" cellpadding="0" cellspacing="0"> 
              <tr> 
                <td valign="top" background="../images/manage_02.gif"> <jsp:include page="navigation.jsp"/> </td> 
              </tr> 
            </table></td> 
          <td align="center" valign="top"><table width="100%" height="120"  border="0" cellpadding="0" cellspacing="0"> 
              <tr> 
                <td valign="top" background="../images/manage_center_placardlist.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0"> 
                    <tr> 
                      <td width="98%" align="right"><a href="placard_add.jsp">[ <img src="../images/list.gif" width="11" height="13">&nbsp;添加公告信息]</a></td> 
                      <td width="2%">&nbsp;</td> 
                    </tr> 
                  </table></td> 
              </tr> 
            </table> 
             
            <form action="../M_SelectBbsServlet?action=dele" method="post" name="frm"> 
            
             
              <table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0"> 
                <tr> 
                  <td valign="top"> <table width="100%" height="14"  border="0" cellpadding="0" cellspacing="0"> </table> 
                    <table width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF"> 
                      <tr bgcolor="#eeeeee"> 
                        <td width="32%" height="24" align="center">公告标题</td> 
                        <td width="60%" align="center">公告内容</td> 
                        <td width="8%" align="center">删除</td> 
                      </tr> 
                    <c:forEach items="${placard}" var="bbs">
                      <tr style="padding:5px;"> 
                        <td height="20" align="center">${bbs.title }</td> 
                       
                        <td height="20" align="center">${bbs.content }</td> 
                        <td align="center"><input name="delid" type="checkbox" class="noborder" value="${bbs.id }"></td> 
                       
                      </tr> 
                    </c:forEach>
                    </table> 
                   
                    <table width="100%"  border="0" cellspacing="0" cellpadding="0"> 
                      <tr> 
                        <td width="60%" height="24">&nbsp;</td> 
                       
                        <td width="40%" align="right"><input name="checkbox" type="checkbox" class="noborder" onClick="CheckAll(frm.delid,frm.checkbox)"> 
                          [全选/反选] [<a style="color:red;cursor:hand;" onclick="checkdel(frm.delid,frm)">删除</a>] 
                          <div id="ch"> 
                            <input name="delid" type="checkbox" class="noborder" value="0"> 
                           
                          </div></td> 
                        
                        <!--层ch用于放置隐藏的checkbox控件，因为当表单中只是一个checkbox控件时，应用javascript获得其length属性值为undefine--> 
                        <script language="javascript">ch.style.display="none";</script> 
                      </tr> 
                    </table></td> 
                </tr> 
              </table> 
            </form> 
           
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
      </table></td> 
  </tr> 
</table> 
</body>
</html>

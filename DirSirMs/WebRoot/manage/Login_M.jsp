<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<head>    
<title>后台管理!</title>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../CSS/style.css" rel="stylesheet">
<script src="../JS/check.jsp"></script>
</head>
<script type="text/javascript">
	window.onload=function(){
		var loginFlag = ${sessionScope.errorMsg != null};
		if (loginFlag) {
			alert('${sessionScope.errorMsg }');
			<%
				session.removeAttribute("errorMsg");
			%>
		}
	};
</script>
<body>
      <table width="350" height="228"  border="0" align="center" cellpadding="0" cellspacing="0" background="../images/login_M.jpg" class="tableBorder">
        <tr>
          <td height="136" align="center">&nbsp;<span style="color:red;">${MSG }</span></td>
        </tr>	  
              
        <tr>  
          <td height="87" align="center" valign="top"><table width="62%" height="87"  border="0" cellpadding="0" cellspacing="0">
      <form name="form1" method="post" action="<%=basePath %>/shop?method=login">
			<tr>
              <td width="95%" align="center">&nbsp;用户名：
              <input name="manager" type="text" id="manager" size="20" value="admin"></td>
              </tr>
            <tr>
              <td align="center">&nbsp;密&nbsp;&nbsp;码：
              <input name="PWD" type="password" id="PWD" size="20" value="123"></td>
              </tr>

            <tr>
              <td align="center"><input name="Submit" type="button" class="btn_grey" value="确认" onClick="checkM(form1)"> &nbsp;
                <input name="Submit2" type="reset" class="btn_grey" value="重置">
              &nbsp;
              <input name="Submit3" type="button" class="btn_grey" value="返回" onClick="window.location.href='../index.jsp';"></td>
              </tr>
             
            </form>
          </table></td>
        </tr>
</table>
</body>
</html>

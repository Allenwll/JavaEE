<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<head>
<title>Go购电子商城后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=basePath %>CSS/style.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath %>JS/jquery.js"></script>

</head>
<script type="text/javascript">
function mycheck(){
	if (form1.goods_name.value==""){
		alert("请输入商品名称！");form1.goodsName.focus();return;
	}
	if (form1.picture.value==""){
		alert("请输入图片文件的路径！");form1.picture.focus();return;
	}
	if (form1.price.value==""){
		alert("请输入商品的定价！");form1.price.focus();return;
	}
	if (isNaN(form1.price.value)){
		alert("您输入的定价错误，请重新输入！");form1.price.value="";form1.price.focus();return;
	}	
	if (form1.introduce.value==""){
		alert("请输入商品简介！");form1.introduce.focus();return;
	}		
	form1.submit();
}

function getSubTypes() {
	$.ajax({
		url:"<%=basePath %>manage/subServlet?action=queryBySupId",
		type:"POST",
		cache:false,
		data:"superTypeId=" + $("#supertype").val(),
		dataType:"json",
		success:function(data) {
			var subType = $("#typeID");
			subType.empty();
			subType.append("<option value='1'>请选择小分类</option>");
			
			for (var index = 0; index < data.length; index++) {
				subType.append("<option value='" + data[index].subTypeId + "'>" + data[index].typeName + "</option>");
			}
		},
		error:function() {
			alert("发生错误");
		}
	});
}


</script>
<body>
<table width="777" height="192"  border="0" align="center" cellpadding="0" cellspacing="0" class="tableBorder">
<tr>
  <td>
<jsp:include page="banner.jsp"/>
<table width="777" height="288"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="182" valign="top">
    <table width="100%" height="431"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="../images/manage_02.gif"><jsp:include page="navigation.jsp"/></td>
      </tr>
    </table></td>
    <td align="center" valign="top"><table width="100%" height="120"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="<%=basePath %>images/manage_center_goodsadd.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
           <td width="98%" align="right"><a href="../M_SeleSuperServlet?action=sele">[ <img src="../images/list.gif" width="11" height="13">&nbsp;大分类信息管理]</a>&nbsp;<a href="../M_SeleSubServlet?action=sele">[ <img src="../images/list.gif" width="11" height="13">&nbsp;小分类信息管理]</a>&nbsp;<a href="<%=basePath %>manage/goodsServlet?action=toSave">[ <img src="../images/list.gif" width="11" height="13">&nbsp;添加商品信息]</a></td>
            <td width="2%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
   			  <form action="<%=basePath %>manage/goodsServlet?action=save" method="post" name="form1" enctype="multipart/form-data">
			    <table width="100%"  border="0" align="center" cellpadding="-2" cellspacing="-2" bordercolordark="#FFFFFF">
                  <tr>
                    <td width="20%" height="27">&nbsp;所属大类：</td>
                    <td width="31%" height="27">&nbsp;
                      <select name="supertype" class="textarea" id="supertype" onchange="getSubTypes()">
                      	<option value="-1">请选择大分类</option>
                      	<c:forEach items="${requestScope.superTypeList }" var="superType">
                      		<option value="${superType.superTypeId }">${superType.typeName }</option>
                      	</c:forEach>
                      </select></td>
                    <td width="20%" height="27"> &nbsp;所属小类：</td>
                  
                    <td width="30%" height="27">&nbsp;
                      <select name="sub_type_id" class="textarea" id="typeID">
                     </select></td>
                  </tr>
                  <tr>
                    <td width="20%" height="27">&nbsp;商品名称：</td>
                    <td height="27" colspan="3">&nbsp;
                      <input name="goods_name" type="text" class="Sytle_text" id="bookID2" size="50">&nbsp;&nbsp;                    </td>
                    </tr>
                  <tr>
                    <td height="41"  width="20%">&nbsp;图片文件：</td>
                    <td height="41">&nbsp;
                          <input name="picture" style="width:150"type="file" class="Style_upload" id="picture">
                    </td>
                    <td height="41"  width="10%">&nbsp;定      价：</td>
                    <td height="41" ><input name="price" type="text" style="width:120" class="Sytle_text" id="price">(元)
                          </td>
                  </tr>
                  <tr>
                    <td height="45"  width="20%">&nbsp;是否新品：</td>
                    <td>&nbsp; <input name="new_goods" type="radio" class="noborder" value="1" checked>
是
  <input name="new_goods" type="radio" class="noborder" value="0">
否</td>
                    <td  width="20%">&nbsp;是否特价：</td>
                    <td><input name="sale" type="radio" class="noborder" value="1" checked>
是
  <input name="sale" type="radio" class="noborder" value="0">
否</td>
                  </tr>
                  <tr>
                    <td height="103"  width="20%">&nbsp;商品简介：</td>
                    <td colspan="3"><span class="style5">&nbsp; </span>
                        <textarea name="introduce" cols="60" rows="5" class="textarea" id="introduce"></textarea></td>
                  </tr>
                  <tr>
                    <td height="38" colspan="4" align="center">
                        <input name="Button" type="button" class="btn_grey" value="保存" onClick="mycheck()">
&nbsp;                        
<input name="Submit2" type="reset" class="btn_grey" value="重置">
                        &nbsp;
                        <input name="Submit3" type="button" class="btn_grey" value="返回" onClick="JScript:history.back(-1)">
                    </td>
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

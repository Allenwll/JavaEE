<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<head>
<title>Go购电子商城后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../CSS/style.css" rel="stylesheet">
<script type="text/javascript" src="../JS/jquery.js"></script>
 <script type="text/javascript">
 function getSubTypes() {
	 $.ajax({
		 url:"<%=basePath %>manage/subServlet?action=queryBySupId",
		 type:"post",
		 cache:false,
		 data:"superTypeId=" + $("#supertype").val(),
		 dataType:"json",
		 success:function(data) {
			 var $subTypeObj = $("#typeID");
			 
			 $subTypeObj.empty();
			 
			 $subTypeObj.append("<option value='-1'>请选择小分类</option>");
			 
			 for (var index = 0; index < data.length; index++) {
				 $subTypeObj.append("<option value='" + data[index].subTypeId + "'>" + data[index].typeName + "</option>");
			 }
			 
		 }
	 });
 }
</script>
</head>
<script language="javascript">
function mycheck(){
	if (form1.goodsName.value==""){
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


</script>
<body>
<input type="hidden" name="superID"  id="superID" value="${upsele.supertype }"/>
<input type="hidden" name="subID"  id="subID" value="${upsele.subtype }"/>
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
        <td valign="top" background="../images/manage_center_goodsmodi.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
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
   			 <form action="<%=basePath %>manage/goodsServlet?action=update" method="post" name="form1" >
			    <table width="100%"  border="0" align="center" cellpadding="-2" cellspacing="-2" bordercolordark="#FFFFFF">
                 <tr>
                
                    <td width="20%" height="27">&nbsp;所属大类： </td>
                    <td width="31%" height="27">&nbsp;
                      <select name="supertype" class="textarea" id="supertype" onchange="getSubTypes()">
                      	<option value="-1">请选择大分类</option>
                      	<c:forEach items="${requestScope.superList }" var="superType">
                      		<c:if test="${requestScope.superTypeId == superType.superTypeId }">
                      			<option value="${superType.superTypeId }" selected="selected">${superType.typeName }</option>
                      		</c:if>
                      		<c:if test="${requestScope.superTypeId != superType.superTypeId }">
	                      		<option value="${superType.superTypeId }">${superType.typeName }</option>
                      		</c:if>
                      	</c:forEach>
                      </select></td>
                    <td width="20%" height="27"> &nbsp;所属小类：</td>
                    <td width="42%" height="27">&nbsp;
                      <select name="typeID" class="textarea" id="typeID">					  
                      		<option value="-1">请选择小分类</option>
					      <c:forEach items="${requestScope.subList }" var="subType">
					      		<c:if test="${requestScope.subTypeId == subType.subTypeId }">
					      			<option value="${subType.subTypeId }" selected="selected">${subType.typeName }</option>
					      		</c:if>
					      		<c:if test="${requestScope.subTypeId != subType.subTypeId }">
					      			<option value="${subType.subTypeId }">${subType.typeName }</option>
					      		</c:if>
					      </c:forEach>
                     </select>
</td>
                  </tr>
                  <tr>
                    <td width="20%" height="27">&nbsp;商品名称：
                      <input name="ID" type="hidden" id="id" value="${goods.goodsId }"></td>
                    <td height="27" colspan="3">&nbsp;
                      <input name="goodsName" type="text" class="Sytle_text" value="${goods.goodsName }" size="50">
                      &nbsp;&nbsp;                    </td>
                    </tr>
                  <tr>
                    <td  width="20%" height="16">&nbsp;图片地址：</td>
                    <td height="27" colspan="3">&nbsp;
                        <input name="picture" type="text" class="Style_upload" id="picture" value="${goods.picture }" readonly="yes" size="30"> 
                        (此处只填写图片文件路径即可)                         </td>
                    </tr>
                  <tr>
                    <td height="27" width="20%" align="center">定　　价：</td>
                    <td height="27">&nbsp;                      <input name="price" type="text" class="Sytle_text" id="price3" value="${goods.price }" size="14">                      
                      (元)</td><td height="27" align="center">现&nbsp;&nbsp;&nbsp;&nbsp;价： </td>
                    <td height="27">&nbsp;<input name="nowPrice" type="text" class="Sytle_text" id="price4" value="${goods.nowPrice }" size="14">
(元)</td>
                  </tr>
                  <tr>
                    <td height="45" width="20%" >&nbsp;是否新品：</td>
                    <c:choose>
                     <c:when test="${goods.newGoods == 1}">
                     <td><input name="newGoods" type="radio" class="noborder" value="${goods.newGoods }" checked="checked" />
是

<input name="newGoods" type="radio" class="noborder" value="0">
否</c:when>
<c:when test="${goods.newGoods==0}">
<td><input name="newGoods" type="radio" class="noborder" value="1" >
是

<input name="newGoods" type="radio" class="noborder" value="${goods.newGoods }"checked>
否</c:when>
</c:choose>


                    <td width="20%" >&nbsp;是否特价：</td>
   <c:choose>
                     <c:when test="${goods.sale==1}">               
                    <td><input name="sale" type="radio" class="noborder" value="${goods.sale }" checked>
是
<input name="sale" type="radio" class="noborder" value="0">
否</c:when>
                   <c:when test="${goods.sale==0}">               
                    <td><input name="sale" type="radio" class="noborder" value="1" >
是
<input name="sale" type="radio" class="noborder" value="${goods.sale }" checked>
否</c:when>
</c:choose>

                </tr>
                  <tr>
                    <td height="103" width="20%" >&nbsp;商品简介：</td>
                    <td colspan="3"><span class="style5">&nbsp; </span>
                        <textarea name="introduce" cols="60" rows="5" class="textarea" id="${upsele.introduce }">${goods.introduce }</textarea></td>
                  </tr>
                  <tr>
                    <td height="38" colspan="4" align="center">
                        <input name="Button" type="button" class="btn_grey" value="保存" onClick="mycheck()">
&nbsp;                        
<input name="Submit2" type="reset" class="btn_grey" value="重置">
                        &nbsp;
                        <input name="Submit3" type="button" class="btn_grey" value="返回" onClick="JScript:history.back()">
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

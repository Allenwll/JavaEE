<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	var globalCode = "";
	function generateCode() {
		//随机生成1000-9999的验证码
		globalCode = parseInt(Math.random() * 9000 + 1000);
		//获取验证码span元素
		var generateCode = document.getElementById("generateCode");
		//为验证码span元素设置文本值
		generateCode.innerHTML = globalCode;

		//设置编码格式
		encodeURIComponent("login.action");
	}
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		})
	});
	function checkCode() {
		//获取要验证的元素
		var code = document.getElementById("code");
		//获取span元素
		var span = document.getElementById("codeSpan");
		if (code.value == globalCode) {
			span.innerHTML = "数据项[验证码]OK";
			return true;
		} else {
			span.innerHTML = "数据项[验证码]输入错误！！！";
			return false;
		}
	}

	function testSubmit() {
		return checkCode();
	}
</script>
</head>

<body
	style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>


	<div class="logintop">
		<span>欢迎登录304班级后台管理界面平台</span>
	</div>

	<div class="loginbody">

		<span class="systemlogo"></span>

		<div class="loginbox loginbox2">
			<form action="user.action" method="post">
				<ul>
					<input type="hidden" name="operate" value="login" />
					<li><font color="red" size="4" style="font-weight:bold ">${errorInfo}</font></li>
					<li><input name="uname" type="text" class="loginuser"
						value="admin" onclick="JavaScript:this.value=''" /></li>
					<li><input name="pwd" type="text" class="loginpwd" value="密码"
						onclick="JavaScript:this.value=''" /></li>
					<li class="yzm"><span><input id="code" name="code"
							type="text" value="验证码" onclick="JavaScript:this.value=''" /></span><cite>XD356<span
							id="generateCode" class="myCode"></span><span id="codeSpan"></span></cite>
					</li>
					<li><input type="submit" class="loginbtn" value="登录" /><label><input
							name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a
							href="#">忘记密码？</a></label></li>
				</ul>
		</div>

	</div>


	<div class="loginbm">
		版权所有304 <a href="http://www.uimaker.com">www.allen.com</a> 朝苍梧兮暮北海
	</div>


</body>

</html>

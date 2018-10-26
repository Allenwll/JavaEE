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
<title>左边</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		//导航切换
		$(".menuson .header").click(
				function() {
					var $parent = $(this).parent();
					$(".menuson>li.active").not($parent).removeClass(
							"active open").find('.sub-menus').hide();
					$parent.addClass("active");
					if (!!$(this).next('.sub-menus').size()) {
						if ($parent.hasClass("open")) {
							$parent.removeClass("open").find('.sub-menus')
									.hide();
						} else {
							$parent.addClass("open").find('.sub-menus').show();
						}
					}
				});
		// 三级菜单点击
		$('.sub-menus li').click(function(e) {
			$(".sub-menus li.active").removeClass("active")
			$(this).addClass("active");
		});
		$('.title').click(function() {
			var $ul = $(this).next('ul');
			$('dd').find('.menuson').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('.menuson').slideUp();
			} else {
				$(this).next('.menuson').slideDown();
			}
		});
	})
</script>
</head>
<body style="background:#f0f9fd;">
	<div class="lefttop">
		<span></span>304班级信息管理系统
	</div>
	<dl class="leftmenu">
		<dd>
			<div class="title">
				<span><img src="images/leftico01.png" /></span>用户信息管理
			</div>
			<ul class="menuson">
				<li>
					<div class="header">
						<cite></cite> <a href="user.action?operate=all"
							target="rightFrame">显示所有用户</a> <i></i>
					</div>
				</li>
				<li>
					<div class="header">
						<cite></cite> <a href="user/addUser.jsp" target="rightFrame">增加用户</a>
						<i></i>
					</div>
				</li>
				<li>
					<div class="header">
						<cite></cite> <a href="user/selUser.jsp" target="rightFrame">查询用户</a>
						<i></i>
					</div>
				</li>
		</dd>
	</dl>
</body>
</html>

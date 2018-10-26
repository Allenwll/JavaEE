<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>操作成功页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<style type="text/css">
body {
	text-align: center;
	font-size: 25px;
}

font {
	color: red;
	font-weight: bold;
}

div {
	margin-top: 200px;
}
</style>
<script language="JavaScript">
	//获取当前时间
	startday = new Date();
	clockStart = startday.getTime();

	function initStopwatch() {
		var myTime = new Date();
		var timeNow = myTime.getTime();
		var timeDiff = timeNow - clockStart; //获取间隔时间
		this.diffSecs = timeDiff / 1000; //因为时间以毫秒为单位
		return (this.diffSecs); //返回间隔秒数
	}

	function getSecs() {
		var mySecs = initStopwatch();
		var mySecs1 = "" + mySecs;
		//以倒计时方式显示时间
		mySecs1 = 5 - eval(mySecs1.substring(0, mySecs1.indexOf(".")));
		var show = document.getElementById("time");
		show.innerHTML = mySecs1;
		window.setTimeout('getSecs()', 1000);

		if (mySecs1 == 0) {
			window.location.href = "user.action?operate=all";
		}
	};

	function timeOut() {
		window.setInterval(function() {
			var num = document.getElementById("time");

			num.innerHTML = num.innerHTML - 1;

			if (num.innerHTML == 0) {
				window.location = "user.action?operate=all";
				return;
			}

		}, 1000);

	}
</script>
</head>

<!--<body onload="window.setTimeout('getSecs()',1)">  -->
<body onload="timeOut();">
	<div>
		用户<font>${message}</font>成功,<font id="time">5</font>秒后跳转到用户显示界面
	</div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">

<title>学习Ajax技术</title>

<script type="text/javascript">
	//页面加载事件
	window.onload = function() {

		document.getElementsByTagName("a")[0].onclick = function() {

			//1.创建XMLHttpRequest对象
			var xhr = null;

			if (window.XMLHttpRequest) {
				//alert("Modren");
				xhr = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				alert("old");
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}

			//2.创建一个连接
			var url = this.href + "?time=" + new Date();

			xhr.open("GET", url);
			//xhr.open("POST", url);

			//3.发送请求
			xhr.send(null);//xhr.send(null);为了防止火狐出错

			//xhr.send("goal=test&uname=momo");//xhr.send(null);为了防止火狐出错

			//4.监听请求过程，每次请求状态值的改变都会触发这个事件，是由服务器触发的。
			xhr.onreadystatechange = function() {
				//alert("状态");
				//alert(xhr.readyState);
				if (xhr.readyState == 4) {//与服务器交互完成
					//http协议状态码
					alert(xhr.status);
					if (xhr.status == 200 || xhr.status == 304) {//ok
						var result = xhr.responseText;//服务器的响应内容
						alert(result);
						//进行需求操作
						document.getElementById("main").innerHTML = result;
					}
				}
			};

			return false;//防止a标签的默认提交事件
		};
	};
</script>

</head>

<body>
	<h1>学习原生Ajax技术</h1>
	<a href="new.jsp">ajax请求</a>
	<a href="hello.txt">ajax请求</a>
	<div style="width:300px;height:200px;border: 1 solid red;" id="main">

	</div>
</body>
</html>

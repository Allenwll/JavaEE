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
<title>增加员工</title>

<script type="text/javascript">
	//方法定义
	function sendAjax(url, success) {

		//1.创建XMLHttpRequest对象
		var xhr = null;
		if (window.XMLHttpRequest) {
			xhr = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
		//2.创建一个连接
		xhr.open("POST", url);

		//3.发送请求
		xhr.send(null);

		//4.监听请求过程，每次请求状态值的改变都会触发这个事件，是由服务器触发的。
		xhr.onreadystatechange = function() {

			if (xhr.readyState == 4) {//与服务器交互完成
				//http协议状态码
				if (xhr.status == 200 || xhr.status == 304) {//ok
					var result = xhr.responseText;//服务器的响应内容
					//alert(result);
					//进行需求操作
					success(result);
				}
			}
		};

		return false;
	};
</script>

<script type="text/javascript">
	window.onload = function() {
		//初始化省份
		sendAjax("/EmplyeeMgs/employee.action?method=findDept",
				function(result) {

					//返回的数据是一个长得像JSON格式的字符串，需要将其转换为JSON对象
					var json = JSON.parse(result);//IE不支持

					console.info(json);

					//在页面进行展示
					var pSelect = document.getElementById("dept");

					for (var i = 0; i < json.length; i++) {
						var p = json[i];

						//下拉框默认的添加新选项的方法
						pSelect.options.add(new Option(p.d_name, p.d_no));
					}

				});
	};
</script>
<script type="text/javascript">
	function checkName() {
		var name = document.getElementById("name");
		if (name.value == "" || name.value == null) {
			document.getElementById("nameSpan").innerHTML = "名字不能为空!";
		}
	}
	function checkAge() {
		var name = document.getElementById("age");
		var reg = /^\d+$/gi;
		if ((!reg.test(name.value)) || name.value == "") {
			document.getElementById("ageSpan").innerText = "年齡不能为空且只能是數字!";
		}
	}
	function checkSal() {
		var name = document.getElementById("sal");
		var reg = /^\d+$/gi;
		if ((!reg.test(name.value)) || name.value == "") {
			document.getElementById("salSpan").innerText = "工资不能为空且只能是數字!";
		}
	}
</script>
</script>
</head>

<body>
	<form action="employee.action?method=add" method="post">
		<table align="center">
			<tr>
				<td colspan="2">&nbsp;&emsp;&emsp;&emsp;&emsp;员工添加</td>

			</tr>

			<tr>
				<br />
				<td>姓名:</td>
				<td><input type="text" name="e_name" id="name"
					onblur="checkName();" /> <span id="nameSpan"></span></td>
			</tr>

			<tr>
				<td>年龄:</td>
				<td><input type="text" name="e_age" id="age"
					onblur="checkAge();" /> <span id="ageSpan"></span></td>

			</tr>

			<tr>
				<td>工资:</td>
				<td><input type="text" name="e_laborage" id="sal"
					onblur="checkSal();" /> <span id="salSpan"></span></td>

			</tr>

			<tr>
				<td>北京住址:</td>
				<td><input type="text" name="e_address" /></td>

			</tr>

			<tr>
				<td>部门:</td>
				<td><select name="dept" id="dept">
						<option value="-1"></option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="注册" /></td>
			</tr>
		</table>
	</form>
</body>
</html>

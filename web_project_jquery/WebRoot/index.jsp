<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<title>JQUERY树状菜单</title>
<style type="text/css">
body {
	font-size: 16px;
	background-color: #FFF;
}

ul li {
	list-style: inside;
	margin-left: 20px;
	list-style: none;
}

#content {
	position: absolute;
	left: 400px;
	top: 20px;
	width: 550px;
	height: 500px;
	border: 1px solid #cccccc;
}

#tips {
	position: absolute;
	z-index: 1;
	border: 1px solid #cccccc;
	background-color: #FFC;
	display: none;
	font-size: 14px;
}

.lightlabel {
	color: red;
	text-decoration: underline;
	cursor: pointer;
}
</style>
<script type="text/javascript" src="script/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	/*window.onload，利用js的onload事件来处理页面加载后的代码
	但是对于jquery，提供的是另一种方案,叫'页面就绪函数'
	使用语法 $(documet).ready(fn)或者 $(fn)
	PS:$是jquery的别名 相当于jquery
	window.onload与$(fn)有本质的不同,onload是在页面资源加载完成后才执行，而$(fn)是在dom解析完成后立即执行
	 */
	//实现树的所有子节点的显示与隐藏
	$(function() {
		//console.info("页面就绪完毕!");
		//jq中最核心就是选择器表达式，用于选中我们所需的组件，并对其进行操作
		//#代表id选择器 
		//利用逗号将多个不同的选择器进行获取--->组合选择器
		$("#lblNews,#lblProducts").click(function() {
			//获取兄弟姐妹元素
			var containerDiv = $(this).siblings("div");
			//判断如果display样式为显示
			if (containerDiv.css("display") == "block") {
				//containerDiv.css("display","none");
				//css 一种使用方式为只传一个参数(属性名).代表获取属性值
				//		另一种为2个参数("屬性名","屬性值")(赋值)
				//设置src属性
				$(this).siblings("#imgOnOff").attr("src", "img/close.gif");
				containerDiv.hide(1000);//隐藏，如果设置一个参数数字 则表示动画时间(毫秒)
				//containerDiv.fadeOut(1000);//淡出
				//containerDiv.slideUp(1000);//下拉
			} else {
				//containerDiv.css("display","block");
				$(this).siblings("#imgOnOff").attr("src", "img/open.gif");
				containerDiv.show(1000);//显示
				//containerDiv.fadeIn(1000);//淡入
				//containerDiv.slideDown(1000);//下拉
			}
		});

	});

	//实现树的展开或折叠
	$(function() {
		$("#openclose").click(function() {
			//$("div[name$='Container']").css("display","none");
			/*
			特征选择器: "标签名[属性名^*$='属性值']"
			 */
			var val = $("div[name$='Container']");//尾匹配属性选择器

			var div = $("div[name^='div']");//首匹配属性选择器

			if (val.css("display") == "block") {
				val.hide(500);
				//全匹配属性选择器
				$("img[name='imgOnOff']").attr("src", "img/close.gif");
			} else {
				div.show(500);
				$("img[name='imgOnOff']").attr("src", "img/open.gif");
			}

		});
	});

	//实现横纵向排列
	$(function() {
		//横向
		$("#horder").click(function() {
			//'>'--->子选择器
			//	$("ul>div>li").css("float","left");

			//'空格'--->后代(层次)选择器
			$("ul li").css("float", "left");

		});
		//纵向
		$("#vorder").click(function() {
			//'>'--->子选择器
			//	$("ul>div>li").css("float","right");

			//'空格'--->后代(层次)选择器
			$("ul li").css("float", "none");
		});
	});

	//显示提示
	$(function() {
		//鼠标经过 event包含了本次事件的内容，比如光标信息等
		$("ul li label").mouseover(function(event) {
			var t = $(this).text();
			$("#tips").html("<b>点击查看【" + t + "】的信息</b>");
			$("#tips").css("left", event.pageX + 10);
			$("#tips").css("top", event.pageY);
			//增加高亮显示
			$(this).addClass("lightlabel");
			$("#tips").show();

		});
		//鼠标移走
		$("ul li label").mouseout(function() {
			$("#tips").hide();
			$("#tips").text("");
			//可以利用JSON格式对数据赋值
			$("#tips").css({
				"left" : 0,
				"top" : 0
			});
			//移除
			$(this).removeClass("lightlabel");
		});
	});

	//点击查看新闻时，利用JQuery中的ajax方法获取数据
	$(function() {
		$("div[name='divNewsContainer'] label").click(
				function() {
					var nt = $(this).attr("ntype");
					$.ajax({
						url : "news.action",//统一资源定位符
						data : "ntype=" + nt,//参数,---->常用Json格式
						type : "get",//post,get
						dataType : "json",//json  jsonp(跨域访问) text  xml  html
						success : function(data) {//成功处理后的数据data和处理代码
							console.info(data);
							$("#content").html("");
							for (var i = 0; i < data.length; i++) {
								var n = data[i];
								$("#content").append(
										"<a href='#'>" + n.title + "(" + n.date
												+ ")</a><br/>");
							}
						},
						error : function(xhr, error, e) {//ajax请求失败后的处理代码
							console.info(xhr);
							console.info(error);
							console.info(e);
							if (xhr.status == 500) {
								alert("服务器异常,请联系管理员!");
							}
						}
					});
				});
	});
	
	//获取logo
	$(function(){
		$("div[name='divProductsContainer'] label").click(function(){
			var url="product.action";
			var p=$(this).attr("product");
			var args={"product":p};
			$("#content").load(url,args);
		});
	});
	
	
</script>
</head>

<body>
	<p>
		<input type="button" name="openclose" id="openclose" value="展开/折叠" />
		<input type="button" name="horder" id="horder" value="横向排列" /> <input
			type="button" name="vorder" id="vorder" value="纵向排列" />
	</p>
	<ul>
		<img id="imgOnOff" name="imgOnOff" src="img/open.gif" />
		<label id="lblNews">&nbsp;国际动态</label>
		<div name="divNewsContainer">
			<li><img src="img/item.gif" /><label id="lblLocal"
				ntype="local">国内新闻</label></li>
			<li><img src="img/item.gif" /><label id="lblInternational"
				ntype="international">国际新闻</label></li>
		</div>
	</ul>
	<br />
	<ul>
		<img id="imgOnOff" name="imgOnOff" src="img/open.gif" />
		<label id="lblProducts">&nbsp;产品展示</label>
		<div name="divProductsContainer">
			<li><img src="img/item.gif" /><label id="lblAdidas"
				product="adidas">阿迪达斯</label></li>
			<li><img src="img/item.gif" /><label id="lblNike"
				product="nike">NIKE</label></li>
			<li><img src="img/item.gif" /><label id="lblKuangWei"
				product="converse">匡威</label></li>
			<li><img src="img/item.gif" /><label id="lblAddNice"
				product="addnice">AddNice</label></li>
			<li><img src="img/item.gif" /><label id="lblLiNing"
				product="lining">李宁</label></li>
			<li><img src="img/item.gif" /><label id="lblLee" product="lee">Lee</label></li>
		</div>
	</ul>
	<div id="tips"></div>

	<div id="content"></div>
</body>
</html>

<%@ page language="java" pageEncoding="utf-8" errorPage="error.jsp"%>
<%@ page import="java.util.*"%>

<h1>测试</h1>

<%
	int i = 1;

	i = i / 0;
%>
<h3>errorPage只对运行时异常起作用，编译不通过，不起作用</h3>


<hr />

<h3>------------------导入文件(静态):两个文件被翻译成一个java文件(执行效率好，耦合性高)----------------</h3>
<h4>静态的，在JSP转换成Servlet时引入文件,它把被插入文件插到当前位置后再进行编译</h4>
<%@ include file="index.jsp"%>
<h3>------------------导入文件(动态)：两个文件被转换成两个对应的java文件(执行效率偏低，耦合性低)----------------</h3>
<h4>动态的，在页面被请求的时候，JSP引擎不把插入文件和原JSP文件合并成一个新的JSP文件，而是在运行时把被插入把文件包含进来</h4>
<jsp:include page="index.jsp" flush="true"></jsp:include>

<h3>如何选用文件导入?----对于今后java代码较小且重用性较高的情况下选用静态导入</h3>
<h3>如果包含页面时需要传递参数，则只能使用动态导入</h3>

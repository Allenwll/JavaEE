<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
//变量是局部？还是全局？
   int a=788;//是局部变量
%>

<%!
   int b=567;//是全局变量，不推荐使用全局变量
%>

<%
 int boy=110;
%>

<%--输出表达式，使用时注意不加“;”号 --%>
<%=boy %>  






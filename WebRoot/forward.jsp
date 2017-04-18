<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'forward.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		var time = 5;
	
		function countDown() {
			document.getElementById("time_span").innerHTML = time;
			time--;
			if (time >= 0) {
				// 设置定时调用
				window.setTimeout("countDown();",1000);
			}
		}
	</script>
  </head>
  
  <body onload="countDown()">
	  <center>
	  	<%
	  		//设置定时跳转
	  		response.setHeader("refresh","5;"+basePath+request.getAttribute("url"));
	  	%>
	  	${message },<span id="time_span">5</span>秒后自动跳转!<br/>
	  	如果没有跳转，请点<a href="${url }">这里</a>
	  </center>
  </body>
</html>

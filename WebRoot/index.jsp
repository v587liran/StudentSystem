<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="sadsadwqdzscacdsa,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <center>
   		<!-- 
    	<s:form action="student_check!login.action" namespace="/" method="post">
    		<s:textfield key="姓名" name="sid"> </s:textfield><br/>
    		<s:password key="密码" name="password"> </s:password><br/>
    		<s:submit key="submit" name="submit" value="提交"></s:submit>
    	</s:form>
    	-->
    	
    	<form action="user!login.action" method="post">
    		用户名<input type="text" name="sid" /><br/>
    		密码<input type="password" name="password" /><br/>
    		学生<input name="type" type="radio" value="1"/>
    		管理员<input name="type" type="radio" value="0"/>
    		<br/>
    		<input type="submit" value="登陆">
    	</form>
    </center>
    
    
  </body>
</html>

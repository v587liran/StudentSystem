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
    
    <title>My JSP 'welcom.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<center>
  		用户ID：<s:property value="student.sid" ></s:property><br/>
  		密码：<s:property value="student.password" ></s:property><br/>
  		<a href="student/student_info.jsp">点击查看个人信息信息</a><br/>
  		<a href="student/student_update.jsp">修改个人信息</a><br/>
  		<a href="user!getCourseList.action">选课</a><br/>
  		<a href="">查看选课</a><br/>
  		<h1>Welcome</h1><br/>
  		
  		<a href="student!testStudent.action">测试连接</a>
  		
  		<br/><br/><br/>
  		用户ID：<s:property value="admin.aid" ></s:property><br/>
  		密码：<s:property value="admin.apassword" ></s:property><br/>
  		<a href="">查看学生列表</a><br/>
  		<a href="">查看所有课程</a><br/>
  		<h1>Welcome</h1><br/>
  	</center>
  </body>
</html>
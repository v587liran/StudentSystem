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
    
    <title>My JSP 'student_info.jsp' starting page</title>
    
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
    	<table border="1" width="50%">
			<tr>
				<td>用户ID</td>
				<td>${student.sid }</td>
			</tr>
			<tr>
				<td>密码</td>
				<td>${student.password }</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>${student.sname }</td>
			</tr>
			<tr>
				<td>性别</td>
				<td>${student.gender }</td>
			</tr>
			<tr>
				<td>出生日期</td>
				<td>${student.birthday }</td>
			</tr>
			<tr>
				<td>联系电话</td>
				<td>${student.telephone }</td>
			</tr>
			<tr>
				<td>家庭住址</td>
				<td>${student.address }</td>
			</tr>
		</table>
		<br/>
		<input type="button" name=submit onclick="javascript:history.back(-1);" value="返回"><br/>
		信息有误？<a href="student/student_update.jsp">点击这里修改信息</a>
    </center>
  </body>
</html>

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
    
    <title>My JSP 'student_update.jsp' starting page</title>
    
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
    		<form action="user!update.action" method="post">
	    		<table border="1" width="50%">
					<tr>
						<td>用户ID</td>
						<td><input type="text" name="sid" value="${student.sid }"></td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input type="text" name="password" value="${student.password }"></td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="sname" value="${student.sname }"></td>
					</tr>
					<tr>
						<td>性别</td>
						<td><input type="text" name="gender" value="${student.gender }"></td>
					</tr>
					<tr>
						<td>出生日期</td>
						<td><input type="text" name="birthday" value="${student.birthday }"></td>
					</tr>
					<tr>
						<td>联系电话</td>
						<td><input type="text" name="telephone" value="${student.telephone }"></td>
					</tr>
					<tr>
						<td>家庭住址</td>
						<td><input type="text" name="address" value="${student.address }"></td>
					</tr>
				</table>
				<input type="submit" value="确认修改"/>
			</form>
    	</center>
  </body>
</html>

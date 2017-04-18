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
    
    <title></title>
    
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
		<form action="" method="post">
			<table border="1">
				<tr>
					<td>课程编号</td>
					<td>${course.cid}</td>
				</tr>
				<tr>
					<td>课程名称</td>
					<td>${course.cname}</td>
				</tr>
				<tr>
					<td>任课教师</td>
					<td>${course.cteacher}</td>
				</tr>
				<tr>
					<td>上课时间</td>
					<td>${course.ctime}</td>
				</tr>
				<tr>
					<td>上课地点</td>
					<td>${course.caddress}</td>
				</tr>
				<tr>
					<td>课程学分</td>
					<td>${course.ccredits}</td>
				</tr>
			</table>
			<br/>
			<input type="button" name=submit onclick="javascript:history.back(-1);" value="返回"><br/>
		</form>
	</center>
  </body>
</html>

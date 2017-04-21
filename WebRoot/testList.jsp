<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testList.jsp' starting page</title>
    
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
    	<table border="1" >
    		<tr>
    			<td>学号</td>
    			<td>密码</td>
    			<td>姓名</td>
    			<td>性别</td>
    			<td>出生日期</td>
    			<td>地址</td>
    			<td>电话</td>
    			<td>操作</td>
    		</tr>
    		<c:forEach items="${allStudentsList}" var="astudent" >
    		<tr>
    			<td>${astudent.sid}</td>
    			<td>${astudent.password}</td>
    			<td>${astudent.sname}</td>
    			<td>${astudent.gender}</td>
    			<td>${astudent.birthday}</td>
    			<td>${astudent.address}</td>
    			<td>${astudent.telephone}</td>
    			<!--  <td><a href="user!aCourseInfo.action?course.cid=${course.cid}">查看</a>&nbsp;<a href="user!getACourse.action?course.cid=${course.cid}">选课</a></td>
    			-->
    		</tr>
    		</c:forEach>
    	</table>
    	
    	<br/>
    	
    	<jsp:include page="../pagePlugin.jsp">
				<jsp:param value="${pageNo}" name="pageNo"/>
				<jsp:param value="${pageSize}" name="pageSize"/>
				<jsp:param value="${keyword}" name="keyword"/>
				<jsp:param value="${column}" name="column"/>
				<jsp:param value="${allCount}" name="allCount"/>
				<jsp:param value="student!getStudentList.action" name="URL"/>
				<jsp:param value="sid:学号|sname:姓名" name="columnData"/>
				<jsp:param value="3" name="pageStyle"/>
    	</jsp:include>
    </center>
  </body>
</html>

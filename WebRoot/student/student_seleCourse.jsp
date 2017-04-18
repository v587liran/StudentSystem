<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
    	<table border="1" >
    		<tr>
    			<td>编号</td>
    			<td>名称</td>
    			<td>任课教师</td>
    			<td>上课时间</td>
    			<td>上课地点</td>
    			<td>学分</td>
    			<td>操作</td>
    		</tr>
    		<c:forEach items="${allCourse}" var="course" >
    		<tr>
    			<td>${course.cid }</td>
    			<td>${course.cname}</td>
    			<td>${course.cteacher}</td>
    			<td>${course.ctime}</td>
    			<td>${course.caddress}</td>
    			<td>${course.ccredits}</td>
    			<td><a href="course!aCourseInfo.action?course.cid=${course.cid}">查看</a>&nbsp<a href="">选课</a></td>
    		</tr>
    		</c:forEach>
    	</table>
    	
    	<br/>
    	<jsp:include page="/pagePlugin.jsp">
				<jsp:param value="${pageNo}" name="pageNo"/>
				<jsp:param value="${pageSize}" name="pageSize"/>
				<jsp:param value="${keyword}" name="keyword"/>
				<jsp:param value="${column}" name="column"/>
				<jsp:param value="${count}" name="count"/>
				<jsp:param value="user!getCourseList.action" name="URL"/>
				<jsp:param value="cid:课程编号|cname:课程名称|cteacher:任课教师" name="columnData"/>
				<jsp:param value="3" name="pageStyle"/>
    	</jsp:include>
    </center>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Admin_CourseList.jsp' starting page</title>
    
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
		<input type="text" value="${key }" name="key"><input type="submit" value="搜索">
		</form>
			<table border="1">
				<tr>
				<th>课程编号</th>
				<th>课程名称</th>
				<th>任课教师</th>
				<th>上课时间</th>
				<th>上课地点</th>
				<th>课程学分</th>
				<th>操作</th>
				</tr>
				<c:forEach var="c" items="${allCourses} ">
				<tr>
				<td>${c.cid}</td>
				<td>${c.cname }</td>
				<td>${c.cteacher }</td>
				<td>${c.ctime }</td>
				<td>${c.caddress }</td>
				<td>${c.credits }</td>
				<td><a href="adminToCourse!getCourseById.action?course.cid=${c.cid}">修改</a>|<a href="adminToCourse!delete.action?course.cid=${c.cid}">删除</a></td>
				</tr>
				</c:forEach>
			</table>
			<br/>
			<input type="button" value="添加" onclick="window.location='adminToCourse!proadd.action'">
			
			<br/>
		<jsp:include page="/courses/split_page_plugin.jsp">
				<jsp:param value="${pageNo}" name="pageNo"/>
				<jsp:param value="${pageSize}" name="pageSize"/>
				<jsp:param value="${column}" name="column"/>
				<jsp:param value="${keyword}" name="keyword"/>
				<jsp:param value="${count}" name="count"/>
				<jsp:param value="adminToCourse!List.action" name="URL"/>
				<jsp:param value="cname:课程名称" name="columnData"/>
				<jsp:param value="3" name="pageStyle"/>
		</jsp:include>
	</center>
  </body>
</html>

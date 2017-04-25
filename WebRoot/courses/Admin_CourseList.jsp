<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 1 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
}
#navi{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	margin:0;
	padding:0;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
#naviDiv{
	font-size:14px;
	color:#333;
	padding-left:10px;
}
#tips{
	margin-top:10px;
	width:100%;
	height:40px;
}
#buttonGroup{
	padding-left:10px;
	float:left;
	height:35px;
}
.button{
	margin-top:20px;
	padding-left:10px;
	padding-right:10px;
	font-size:14px;
	width:70px;
	height:30px;
	line-height:30px;
	vertical-align:middle;
	text-align:center;
	cursor:pointer;
    border-color: #77D1F6;
    border-width: 1px;
    border-style: solid;
    border-radius: 6px 6px;
    -moz-box-shadow: 2px 2px 4px #282828;
    -webkit-box-shadow: 2px 2px 4px #282828;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, #BFBFBF));
}
#mainContainer{
	padding-left:10px;
	padding-right:10px;
	text-align:left;
	width:98%;
	font-size:16px;
}
</style>
</head>

<body>
	<script type="text/javascript" src="js/Calendar3.js"></script>
	<div id="navi">
		<div id='naviDiv'>
			<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;课程管理<span>&nbsp;
			<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;课程列表<span>&nbsp;
		</div>
	</div>
	<div id="tips"></div>
	<div id="mainContainer">
	<center>
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
			<c:forEach var="ac" items="${courseList }">
				<tr>
					<td>${ac.cid }</td>
					<td>${ac.cname }</td>
					<td>${ac.cteacher }</td>
					<td>${ac.ctime }</td>
					<td>${ac.caddress }</td>
					<td>${ac.ccredits }</td>
					<td>
						<a href="adminToCourse!findCourse.action?course.cid=${ac.cid}">查看</a>&nbsp;<a
							href="adminToCourse!getCourseById?course.cid=${ac.cid}">修改</a>&nbsp;<a
							href="adminToCourse!delete.action?course.cid=${ac.cid}"
							onclick="return window.confirm('确定要删除该数据吗?');">删除</a>
					</td>

				</tr>
			</c:forEach>
		</table>
		<jsp:include page="/pagePlugin.jsp">
			<jsp:param value="${pageNo}" name="pageNo" />
			<jsp:param value="${pageSize}" name="pageSize" />
			<jsp:param value="${keyword}" name="keyword" />
			<jsp:param value="${column}" name="column" />
			<jsp:param value="${allCount}" name="count" />
			<jsp:param value="adminToCourse!getCourses.action" name="URL" />
			<jsp:param value="cid:课程编号|cname:课程名称" name="columnData" />
			<jsp:param value="3" name="pageStyle" />
		</jsp:include>
	</center>
</body>
</html>

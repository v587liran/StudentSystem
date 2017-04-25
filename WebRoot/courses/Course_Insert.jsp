<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Course_Insert.jsp' starting page</title>
    
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
			<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;添加课程<span>&nbsp;
		</div>
	</div>
	<div id="tips"></div>
	<div id="mainContainer">
    <center>
		<form action="${url }" method="post">
			<table border="1">
				<tr>
					<td>课程编号</td>
					<td><input type="text" name="course.cid" value="${course.cid }"></td>
				</tr>
				<tr>
					<td>课程名称</td>
					<td><input type="text" name="course.cname" value="${course.cname }"></td>
				</tr>
				<tr>
					<td>任课教师</td>
					<td><input type="text" name="course.cteacher" value="${course.cteacher}"></td>
				</tr>
				<tr>
					<td>上课时间</td>
					<td><input type="text" name="course.ctime" value="${course.ctime }"></td>
				</tr>
				<tr>
					<td>上课地点</td>
					<td><input type="text" name="course.caddress" value="${course.caddress }"></td>
				</tr>
				<tr>
					<td>课程学分</td>
					<td><input type="text" name="course.ccredits" value="${course.ccredits }"></td>
				</tr>
			</table>
			<br/>
			<input type="submit" value="确认"><br/>
		</form>
	</center>
  </body>
</html>

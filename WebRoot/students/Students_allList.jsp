<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
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
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/default.css" />
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
<body>
<script type="text/javascript" src="js/Calendar3.js"></script>

	<div id="navi">
		<div id='naviDiv'>
			<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;学生管理<span>&nbsp;</span>
			<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;学生列表<span>&nbsp;</span>
		</div>
	</div>
	<div id="tips"></div>
	<div id="mainContainer">
	
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
    		<c:forEach items="${allStudentsList}" var="student" >
    		<tr>
    			<td>${student.sid}</td>
    			<td>${student.password}</td>
    			<td>${student.sname}</td>
    			<td>${student.gender}</td>
    			<td>${student.birthday}</td>
    			<td>${student.address}</td>
    			<td>${student.telephone}</td>
    			<td><a href="student!getAStudentInfo.action?student.sid=${student.sid}">查看</a>&nbsp;<a href="student!showStudentInfo.action?sid=${student.sid}">修改</a>&nbsp;<a href="student!delete.action?student.sid=${student.sid}" onclick="return window.confirm('确定要删除该数据吗?');">删除</a></td>
    			
    		</tr>
    		</c:forEach>
    	</table>
    	
    	<br/>
    	
    	<jsp:include page="/pagePlugin.jsp">
				<jsp:param value="${pageNo}" name="pageNo"/>
				<jsp:param value="${pageSize}" name="pageSize"/>
				<jsp:param value="${keyword}" name="keyword"/>
				<jsp:param value="${column}" name="column"/>
				<jsp:param value="${allCount}" name="count"/>
				<jsp:param value="student!getStudentList.action" name="URL"/>
				<jsp:param value="sid:学号|sname:姓名" name="columnData"/>
				<jsp:param value="3" name="pageStyle"/>
    	</jsp:include>
    </center>
</div>
</body>
</html>
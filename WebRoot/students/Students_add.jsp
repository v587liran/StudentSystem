<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
			<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;个人信息管理<span>&nbsp;
			<span><img src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;修改个人信息<span>&nbsp;
		</div>
	</div>
	<div id="tips"></div>
	<div id="mainContainer">
	
	<center>
    		<form action="student!add.action" method="post">
	    		<table border="1" width="50%">
					<tr>
						<td>用户ID</td>
						<td><input type="text" name="sid"></td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input type="text" name="password""></td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="sname" ></td>
					</tr>
					<tr>
						<td>性别</td>
						<td><input type="text" name="gender"></td>
					</tr>
					<tr>
						<td>出生日期</td>
						<td><input type="text" name="birthday" ></td>
					</tr>
					<tr>
						<td>联系电话</td>
						<td><input type="text" name="telephone" ></td>
					</tr>
					<tr>
						<td>家庭住址</td>
						<td><input type="text" name="address"></td>
					</tr>
				</table>
				<input type="submit" value="添加"/>
			</form>
    	</center>
</div>
</body>
</html>
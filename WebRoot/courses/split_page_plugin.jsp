<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  </head>
  
  <body>
  
  <%--
  	使用说明:
  		列表时,将以下内容粘贴到需要分页显示的位置
  			<jsp:include page="/split_page_plugin.jsp">
				<jsp:param value="${pageNo}" name="pageNo"/>
				<jsp:param value="${pageSize}" name="pageSize"/>
				<jsp:param value="${column}" name="column"/>
				<jsp:param value="${keyword}" name="keyword"/>
				<jsp:param value="${count}" name="count"/>
				<jsp:param value="news!list.action" name="URL"/>
				<jsp:param value="title:标题|content:内容" name="columnData"/>
				<jsp:param value="1" name="pageStyle"/>
			</jsp:include>
			
			其中:
				URL为查询列表的路径.
				columnData为搜索功能的选项处理,格式:  字段名:显示文字|字段名2:显示文字2.....
				pageStyle为分页组件样式,其中1 为数字版,2为下拉列表,3或默认为文本框
			
  	
  
  --%>
  				
			<br/>
			
			<%
				int pageNo = Integer.parseInt(request.getParameter("pageNo"));
				int pageSize = Integer.parseInt(request.getParameter("pageSize"));
				int count = Integer.parseInt(request.getParameter("count"));
				int allPages = (count - 1) / pageSize + 1;
				
				String column = request.getParameter("column");
				String keyword = request.getParameter("keyword");
				
				String URL = request.getParameter("URL");
			
			%>
			
			<form action="<%=URL %>" id="split_form" method="post" onsubmit="return checkPageNo();">				
			
				<%
					String pageStyle = request.getParameter("pageStyle");
				
					if ("1".equals(pageStyle)) {
				%>
			
				<input type="button" value="<<" <%=pageNo==1?"disabled":"" %> onclick="changePage(1);"/>				
				<input type="button" value="<" <%=pageNo==1?"disabled":"" %> onclick="changePage(<%=pageNo-1 %>);"/>
				
				<%
					if (pageNo - 2 > 1 ) {
				%>
				...
				<%			
					}
				
					for (int i = pageNo - 2; i <= pageNo + 2 && i <= allPages;i++) {
						if (i == pageNo) {
				%>
				<font color="red"><%=i %></font>
				<%			
						}
						
					else if (i > 0) {
				%>
					<a href="javascript:changePage(<%=i %>);"><%=i %></a>
				<%		
						}
						
					
					}
				
					if (pageNo + 2 < allPages) {
					%>
					...
					<%			
							}
				%>
				
				
				
				<input type="button" value=">" <%=allPages==pageNo?"disabled":"" %>  onclick="changePage(<%=pageNo+1 %>)"/>
				<input type="button" value=">>" <%=allPages==pageNo?"disabled":"" %> onclick="changePage(<%=allPages %>);"/>
				
				<input type="hidden" name="pageNo" id="pageNo" value="<%=pageNo %>"/>
				
				<%
					} else if ("2".equals(pageStyle)) {
				%>
				<input type="button" value="首页" <%=pageNo==1?"disabled":"" %> onclick="changePage(1);"/>
				<input type="button" value="上一页" <%=pageNo==1?"disabled":"" %> onclick="changePage(<%=pageNo - 1 %>);"/>
				<input type="button" value="下一页" <%=allPages == pageNo?"disabled":"" %> onclick="changePage(<%=pageNo + 1 %>);"/>
				<input type="button" value="尾页" <%=allPages == pageNo?"disabled":"" %> onclick="changePage(<%=allPages %>);"/>
				
				跳转到
				<select id="pageNo" name="pageNo" onchange="changePage(this.value);">
					<%
						for (int i = 1; i <= allPages ;i++) {
					%>
					<option value="<%=i %>" <%=i==pageNo?"selected":"" %>><%=i %></option>
					<%
						}
					%>
				</select>
				页 
				
				<%		
						
					} else {
				%>
				<input type="button" value="首页" <%=pageNo==1?"disabled":"" %> onclick="changePage(1);"/>
				<input type="button" value="上一页" <%=pageNo==1?"disabled":"" %> onclick="changePage(<%=pageNo - 1 %>);"/>
				<input type="button" value="下一页" <%=allPages == pageNo?"disabled":"" %> onclick="changePage(<%=pageNo + 1 %>);"/>
				<input type="button" value="尾页" <%=allPages == pageNo?"disabled":"" %> onclick="changePage(<%=allPages %>);"/>
				
				跳转到
				<input type="text" id="pageNo" name="pageNo" size="3" maxlength="3" value="<%=pageNo %>"/>
				页 <input type="submit" value="Go"/>
				<%		
					}
				%>
				
				<%
					int[] allSize = {1,2,5,10,20};
				%>
				每页显示
				<select name="pageSize" id="pageSize" onchange="changePage(1);">
					<%
						for (int i = 0;i < allSize.length;i++) {
					%>	
					<option value="<%=allSize[i] %>" <%=allSize[i]==pageSize?"selected":"" %>><%=allSize[i] %></option>
					<%
						}
					%>
				</select>
				条数据
				
				<br/>
				<select name="column" id="column">
					<%
						String columnData = request.getParameter("columnData");
						String[] dataValues = columnData.split("\\|");
						for (int i = 0;i < dataValues.length;i++) {
							String[] values = dataValues[i].split(":");
					%>
					<option value="<%=values[0] %>" <%=values[0].equals(column)?"selected":"" %>><%=values[1] %></option>
					<%		
						}
					
					%>
				</select>
				<input type="text" name="keyword" value="<%=keyword %>"/>
				<input type="submit" value="搜索"/>				
			</form> 
			
			<script type="text/javascript">
				function changePage(newPage) {
					// 改变页数
					document.getElementById("pageNo").value = newPage;
					// 提交表单,改变显示内容
					document.getElementById("split_form").submit();
				}
				
				function checkPageNo() {
					// 取得当前输入的页数
					var pageNo = document.getElementById("pageNo").value;
					// 判断是否是合法的数字
					// 在js里,使用 /^格式$/.test(内容) 来测试内容是否匹配某个格式 
					// \d(数字),\w(字母,数字或下划线), +(前面的内容有1个以上),?(0个或1个),*(有没有都可以)
					// 如果符合条件,则返回true,否则返回false 
					if (/^\d+$/.test(pageNo)) {
						// 还要判断是否在范围内
						if (pageNo >= 1 && pageNo <= <%=allPages%>) {
							// 合法
							return true;
						}
					}
					return false;
				}
			</script>
  
  
  </body>
</html>

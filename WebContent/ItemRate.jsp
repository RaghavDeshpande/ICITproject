

<%@page import="pojo.ItemRatePojo"%>
<%@page import="model.ItemRateBean"%>

<%@page import="java.util.List"%>
<%@page import="model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Item Rate</title>
	</head>
	<body>
		<div id="itemRateHeader" class="itemRateHeader" align="center">
			<table align="right">
				<tr>
					<td>
						<h4>
							<a href="NewItemRate.jsp">New ItemRate</a>
						</h4>
					</td>
					<td></td>
					<td>
						<h4>
							<a href="login.html">Logout</a>
						</h4>
					</td>
			</table>
		</div>
		<div align="center" id="itemRateView" class="itemRateView">
			<table>
				<tr>
					<th>Branch GroupId</th>
					<th>ItemId</th>
					<th>ItemRate</th>
					
				</tr>
					<%
						UserBean bean = (UserBean)session.getAttribute("user");
						if(bean.authenticate()){
							List<Object> list = (List)request.getAttribute("ItemRateList");
							for(Object object : list ){
							ItemRatePojo pojo = (ItemRatePojo)object;
							%>
				<tr>
					<td>	<%= pojo.getBranchGroupId() %> </td>
					<td>	<%=pojo.getItemId()%> </td>
					<td>	<%=pojo.getItemRate() %> </td>
					<td>	<a href="controller?page=updateItemRate&branchgroupid= <%= pojo.getBranchGroupId()%>">Update</a>	</td>
					<td>	<a href="controller?page=deleteItemRate&branchgroupid= <%= pojo.getBranchGroupId()%>">Delete</a>	</td>
				</tr>			
							<%
							}
						}
					%>
				
			</table>
		</div>
	</body>
</html>
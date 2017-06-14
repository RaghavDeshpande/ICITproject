<%@page import="pojo.ItemGroupPojo"%>
<%@page import="model.ItemGroupBean"%>
<%@page import="java.util.List"%>
<%@page import="model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>branch</title>
	</head>
	<body>
		<div id="itemGroupHeader" class="itemGroupHeader" align="center">
			<table align="right">
				<tr>
					<td>
						<h4>
							<a href="NewItemGroup.jsp">New ItemGroup</a>
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
		<div align="center" id="itemGroupView" class="itemGroupView">
			<table>
				<tr>
					<th>ItemGroup Id</th>
					<th>ItemGroup description</th>
				</tr>
					<%
						UserBean bean = (UserBean)session.getAttribute("user");
						if(bean.authenticate()){
							List<Object> list = (List)request.getAttribute("ItemGroupList");
							for(Object object : list ){
							ItemGroupPojo pojo = (ItemGroupPojo)object;
							%>
				<tr>
					<td>	<%= pojo.getItemGroupId() %> </td>
					<td>	<%=pojo.getDescription() %> </td>
					
					<td>	<a href="controller?page=updateItemGroup&itemgroupid= <%= pojo.getItemGroupId()%>">Update</a>	</td>
					<td>	<a href="controller?page=deleteItemGroup&itemgroupid= <%= pojo.getItemGroupId()%>">Delete</a>	</td>
				</tr>			
							<%
							}
						}
					%>
				
			</table>
		</div>
	</body>
</html>
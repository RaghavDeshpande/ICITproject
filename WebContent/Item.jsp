<%@page import="pojo.ItemPojo"%>
<%@page import="model.ItemBean"%>
<%@page import="java.util.List"%>
<%@page import="model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>item</title>
	</head>
	<body>
		<div id="itemHeader" class="itemHeader" align="center">
			<table align="right">
				<tr>
					<td>
						<h4>
							<a href="NewItem.jsp">New Item</a>
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
		<div align="center" id="itemView" class="itemView">
			<table>
				<tr>
					<th>Item Id</th>
					<th>Item Descriptor</th>
					<th>Vehicle</th>
					<th>Item Group Id</th>
				</tr>
					<%
						UserBean bean = (UserBean)session.getAttribute("user");
						if(bean.authenticate()){
							List<Object> list = (List)request.getAttribute("ItemList");
							for(Object object : list ){
							ItemPojo pojo = (ItemPojo)object;
							%>
				<tr>
					<td>	<%= pojo.getItemId() %> </td>
					<td>	<%=pojo.getItemDescriptor() %> </td>
					<td>	<%=pojo.getVehicle() %> </td>
					<td>	<%=pojo.getItemGroupId()%> </td>
					<td>	<a href="controller?page=updateItem&itemid= <%= pojo.getItemId()%>">Update</a>	</td>
					<td>	<a href="controller?page=deleteItem&itemid= <%= pojo.getItemId()%>">Delete</a>	</td>
				</tr>			
							<%
							}
						}
					%>
				
			</table>
		</div>
	</body>
</html>
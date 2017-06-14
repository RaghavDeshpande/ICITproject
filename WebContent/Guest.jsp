<%@page import="pojo.GuestPojo"%>
<%@page import="model.GuestBean"%>
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
		<div id="guestHeader" class="guestHeader" align="center">
			<table align="right">
				<tr>
					<td>
						<h4>
							<a href="NewGuest.jsp">New Guest</a>
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
		<div align="center" id="guestView" class="guestView">
			<table>
				<tr>
					<th> guestId</th>
					<th> guestName</th>
					<th> guestAddress</th>
				</tr>
					<%
						UserBean bean = (UserBean)session.getAttribute("user");
						if(bean.authenticate()){
							List<Object> list = (List)request.getAttribute("GuestList");
							for(Object object : list ){
							GuestPojo pojo = (GuestPojo)object;
							%>
				<tr>
					<td>	<%= pojo.getGuestId() %> </td>
					<td>	<%=pojo.getGuestName() %> </td>
					<td>	<%=pojo.getGuestAddress() %> </td>
					<td>	<a href="controller?page=updateGuest&guestid= <%= pojo.getGuestId()%>">Update</a>	</td>
					<td>	<a href="controller?page=deleteGuest&guestid= <%= pojo.getGuestId()%>">Delete</a>	</td>
				</tr>			
							<%
							}
						}
					%>
				
			</table>
		</div>
	</body>
</html>
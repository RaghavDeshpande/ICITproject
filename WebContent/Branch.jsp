<%@page import="pojo.BranchPojo"%>
<%@page import="model.BranchBean"%>
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
		<div id="branchHeader" class="branchHeader" align="center">
			<table align="right">
				<tr>
					<td>
						<h4>
							<a href="NewBranch.jsp">New Branch</a>
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
		<div align="center" id="branchView" class="branchView">
			<table>
				<tr>
					<th>Branch Id</th>
					<th>Branch Name</th>
					<th>Branch Address</th>
					<th>Branch Phone</th>
				</tr>
					<%
						UserBean bean = (UserBean)session.getAttribute("user");
						if(bean.authenticate()){
							List<Object> list = (List)request.getAttribute("BranchList");
							for(Object object : list ){
							BranchPojo pojo = (BranchPojo)object;
							%>
				<tr>
					<td>	<%= pojo.getBranchId() %> </td>
					<td>	<%=pojo.getBranchName() %> </td>
					<td>	<%=pojo.getBranchAddress() %> </td>
					<td>	<%=pojo.getBranchPhone()%> </td>
					<td>	<a href="controller?page=updateBranch&branchid= <%= pojo.getBranchId()%>">Update</a>	</td>
					<td>	<a href="controller?page=deleteBranch&branchid= <%= pojo.getBranchId()%>">Delete</a>	</td>
				</tr>			
							<%
							}
						}
					%>
				
			</table>
		</div>
	</body>
</html>
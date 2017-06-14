<%@page import="pojo.BranchGroupPojo"%>
<%@page import="model.BranchGroupBean"%>
<%@page import="java.util.List"%>
<%@page import="model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>branchGroup</title>
	</head>
	<body>
		<div id="branchGroupHeader" class="branchGroupHeader" align="center">
			<table align="right">
				<tr>
					<td>
						<h4>
							<a href="NewBranchGroup.jsp">New Branch</a>
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
		<div align="center" id="branchGroupView" class="branchGroupView">
			<table>
				<tr>
					<th> branchGroupId</th>
					<th>  branchId1</th>
					<th>  branchId2</th>
					<th>  splFerryTime</th>
				</tr>
					<%
						
							List<Object> list = (List)request.getAttribute("BranchGroupList");
							for(Object object : list ){
							BranchGroupPojo pojo = (BranchGroupPojo)object;
							%>
				<tr>
					<td>	<%= pojo.getBranchGroupId() %> </td>
					<td>	<%=pojo.getBranchId1() %> </td>
					<td>	<%=pojo.getBranchId2() %> </td>
					<td>	<%=pojo.getSplFerryTime()%> </td>
					<td>	<a href="controller?page=updateBranchGroup&branchgroupid= <%= pojo.getBranchGroupId()%>">Update</a>	</td>
					<td>	<a href="controller?page=deleteBranchGroup&branchgroupid= <%= pojo.getBranchGroupId()%>">Delete</a>	</td>
				</tr>			
							<%
							
						}
					%>
				
			</table>
		</div>
	</body>
</html>
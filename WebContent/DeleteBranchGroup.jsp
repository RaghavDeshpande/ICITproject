<%@page import="model.BranchGroupBean"%>
<%@page import="pojo.BranchGroupPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Delete BranchGroup</title>
	</head>
	<body>
		<%
		BranchGroupBean bean = (BranchGroupBean)request.getAttribute("branchgroupBean");
	%>
	<form action="controller?page=BranchGroupDelete" method="post">
		 branchGroupId : <input type="text" name="branchGroupIdD" value="<%=bean.getBranchGroupId() %>"><br>
		 branchId1 : <input type="text" name="branchId1D" value="<%=bean.getBranchId1() %>"><br>
		 branchId2 : <input type="text" name="branchId2D" value="<%=bean.getBranchId2() %>"><br>
		 splFerryTime : <input type="text" name="splFerryTimeD" value="<%=bean.getSplFerryTime() %>"><br>
		<input type="submit" value="Delete"> 
	</body>
</html>
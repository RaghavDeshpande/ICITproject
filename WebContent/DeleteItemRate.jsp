<%@page import="model.ItemRateBean"%>
<%@page import="pojo.ItemRatePojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Delete ItemRate</title>
	</head>
	<body>
		<%
		ItemRateBean bean = (ItemRateBean)request.getAttribute("itemrateBean");
	%>
	<form action="controller?page=ItemRateDelete" method="post">
		Branch GroupId : <input type="text" name="branchGroupId" value="<%=bean.getBranchGroupId() %>"><br>
		ItemId : <input type="text" name="itemId" value="<%=bean.getItemId() %>"><br>
		ItemRate : <input type="text" name="itemRate" value="<%=bean.getItemRate() %>"><br>
		<input type="submit" value="Delete"> 
	</body>
</html>
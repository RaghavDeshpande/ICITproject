<%@page import="model.BranchGroupBean"%>
<%@page import="pojo.BranchGroupPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update BranchGroup</title>
</head>
<body>
	<%
	BranchGroupBean bean = (BranchGroupBean)request.getAttribute("branchGroupBean");
	%>
	<form action="controller?page=BranchGroupUpdate" method="post">
		 branchGroupId : <input type="text" name="branchGroupIdU" value="<%=bean.getBranchGroupId() %>"><br>
		 branchId1 : <input type="text" name="branchId1U" value="<%=bean.getBranchId1() %>"><br>
		 branchId2 : <input type="text" name="branchId2U" value="<%=bean.getBranchId2() %>"><br>
		 splFerryTime : <input type="number" name="splFerryTimeU" value="<%=bean.getSplFerryTime() %>"><br>
		<input type="submit" value="Submit"> 
	</form>
</body>
</html>
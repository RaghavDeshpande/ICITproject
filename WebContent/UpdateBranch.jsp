<%@page import="model.BranchBean"%>
<%@page import="pojo.BranchPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Branch</title>
</head>
<body>
	<%
		BranchBean bean = (BranchBean)request.getAttribute("branchBean");
	%>
	<form action="controller?page=BranchUpdate" method="post">
		Branch Id : <input type="text" name="branchIdU" value="<%=bean.getBranchId() %>"><br>
		Branch Name : <input type="text" name="branchNameU" value="<%=bean.getBranchName() %>"><br>
		Branch Address : <input type="text" name="branchAddU" value="<%=bean.getBranchAddress() %>"><br>
		Branch Phone : <input type="number" name="branchPhoneU" value="<%=bean.getBranchPhone() %>"><br>
		<input type="submit" value="Submit"> 
	</form>
</body>
</html>
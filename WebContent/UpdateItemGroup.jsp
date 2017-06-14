<%@page import="model.ItemGroupBean"%>
<%@page import="pojo.ItemGroupPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update ItemGroup</title>
</head>
<body>
	<%
		ItemGroupBean bean = (ItemGroupBean)request.getAttribute("itemgroupBean");
	%>
	<form action="controller?page=itemgroupupdate" method="post">
		ItemGroup Id : <input type="text" name="itemGroupIdU" value="<%=bean.getItemGroupId()%>"><br>
		ItemGroup description : <input type="text" name="descriptionU" value="<%=bean.getDescription() %>"><br>
	
		<input type="submit" value="Submit"> 
	</form>
</body>
</html>
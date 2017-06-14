<%@page import="model.ItemBean"%>
<%@page import="pojo.ItemPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update item</title>
</head>
<body>
	<%
	ItemBean bean = (ItemBean)request.getAttribute("itemBean");
	%>
	<form action="controller?page=ItemUpdate" method="post">
		Item Id : <input type="text" name="itemId" value="<%=bean.getItemId() %>"><br>
		Item Descriptor : <input type="text" name="itemDescriptor" value="<%=bean.getItemDescriptor() %>"><br>
		Vehicle : <input type="text" name="vehicle" value="<%=bean.getVehicle() %>"><br>
		Item GroupId : <input type="text" name="itemGroupId" value="<%=bean.getItemGroupId() %>"><br>
		<input type="submit" value="Submit"> 
	</form>
</body>
</html>
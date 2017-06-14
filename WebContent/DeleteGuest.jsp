<%@page import="model.GuestBean"%>
<%@page import="pojo.GuestPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Delete Guest</title>
	</head>
	<body>
		<%
		GuestBean bean = (GuestBean)request.getAttribute("guestBean");
	%>
	<form action="controller?page=GuestDelete" method="post">
		Guest guestId : <input type="text" name="guestIdD" value="<%=bean.getGuestId() %>"><br>
		Guest guestName : <input type="text" name="guestNameD" value="<%=bean.getGuestName() %>"><br>
		Guest guestAddress : <input type="text" name="guestAddressD" value="<%=bean.getGuestAddress() %>"><br>
		<input type="submit" value="Delete"> 
	</body>
</html>
<%@page import="model.GuestBean"%>
<%@page import="pojo.GuestPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Guest</title>
</head>
<body>
	<%
		GuestBean bean = (GuestBean)request.getAttribute("guestBean");
	%>
	<form action="controller?page=GuestUpdate" method="post">
		Guest guestId : <input type="text" name="guestIdU" value="<%=bean.getGuestId() %>"><br>
		Guest guestName : <input type="text" name="guestNameU" value="<%=bean.getGuestName() %>"><br>
		Guest guestAddress : <input type="text" name="guestAddressU" value="<%=bean.getGuestAddress() %>"><br>
		<input type="submit" value="Submit"> 
	</form>
</body>
</html>
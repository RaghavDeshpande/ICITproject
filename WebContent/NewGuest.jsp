<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>guest</title>
</head>
<body>
	<div id="guestInput" class="guestI" align="center">
		<form action="controller?page=newguest" method="post">
			<table>
				<tr>
					<td>Guest guestId:</td>
					<td> <input type="text" name="guestId" class="guestI"></td>
				</tr>
				<tr>
					<td>Guest guestName:</td>
					<td> <input type="text" name="guestName" class="guestI"></td>
				</tr>
				<tr>
					<td>Guest guestAddress:</td>
					<td> <input type="text" name="guestAddress" class="guestI"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"> <input type="submit" id="guestSubmit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
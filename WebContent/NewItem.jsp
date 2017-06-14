<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>branch</title>
</head>
<body>
	<div id="itemInput" class="itemI" align="center">
		<form action="controller?page=newitem" method="post">
			<table>
				<tr>
					<td>Item Id:</td>
					<td> <input type="text" name="itemId" class="itemI"></td>
				</tr>
				<tr>
					<td>Item Descriptor:</td>
					<td> <input type="text" name="itemDescriptor" class="itemI"></td>
				</tr>
				<tr>
					<td>Vehicle:</td>
					<td> <input type="text" name="vehicle" class="itemI"></td>
				</tr>
				<tr>
					<td>Item Group Id:</td>
					<td> <input type="text" name="itemGroupId" class="itemI"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"> <input type="submit" id="itemSubmit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
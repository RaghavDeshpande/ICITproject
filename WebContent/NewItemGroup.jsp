<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>itemGroup</title>
</head>
<body>
	<div id="itemGroupInput" class="itemGroupI" align="center">
		<form action="controller?page=newitemgroup" method="post">
			<table>
				<tr>
					<td>ItemGroup Id:</td>
					<td> <input type="text" name="itemGroupId" class="itemGroupIdI"></td>
				</tr>
				<tr>
					<td>ItemGroup description:</td>
					<td> <input type="text" name="description" class="itemGroupIdI"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"> <input type="submit" id="itemGroupId" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
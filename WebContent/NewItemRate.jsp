<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>item rate</title>
</head>
<body>
	<div id="itemRateInput" class="itemRateI" align="center">
		<form action="controller?page=newitemrate" method="post">
			<table>
				<tr>
					<td>Branch GroupId:</td>
					<td> <input type="text" name="branchGroupId" class="itemRateI"></td>
				</tr>
				<tr>
					<td>ItemId:</td>
					<td> <input type="text" name="itemId" class="itemRateI"></td>
				</tr>
				<tr>
					<td>ItemRate:</td>
					<td> <input type="text" name="itemRate" class="itemRateI"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"> <input type="submit" id="itemRateSubmit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
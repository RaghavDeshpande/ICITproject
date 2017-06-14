<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>branchGroup</title>
</head>
<body>
	<div id="branchGroupInput" class="branchGroupI" align="center">
		<form action="controller?page=newbranchgroup" method="post">
			<table>
				<tr>
					<td> branchGroupId:</td>
					<td> <input type="text" name="branchGroupId" class="branchGroupI"></td>
				</tr>
				<tr>
					<td> branchId1:</td>
					<td> <input type="text" name="branchId1" class="branchGroupI"></td>
				</tr>
				<tr>
					<td> branchId2:</td>
					<td> <input type="text" name="branchId2" class="branchGroupI"></td>
				</tr>
				<tr>
					<td> splFerryTime:</td>
					<td> <input type="text" name="splFerryTime" class="branchGroupI"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"> <input type="submit" id="branchGroupSubmit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
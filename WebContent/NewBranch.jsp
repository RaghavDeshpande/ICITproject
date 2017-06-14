<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>branch</title>
</head>
<body>
	<div id="branchInput" class="branchI" align="center">
		<form action="controller?page=newbranch" method="post">
			<table>
				<tr>
					<td>Branch Id:</td>
					<td> <input type="text" name="branchId" class="branchI"></td>
				</tr>
				<tr>
					<td>Branch Name:</td>
					<td> <input type="text" name="branchName" class="branchI"></td>
				</tr>
				<tr>
					<td>Branch Address:</td>
					<td> <input type="text" name="branchAdd" class="branchI"></td>
				</tr>
				<tr>
					<td>Branch Phone:</td>
					<td> <input type="text" name="branchPhone" class="branchI"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"> <input type="submit" id="branchSubmit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
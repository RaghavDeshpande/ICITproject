<%@page import="pojo.UserPojo"%>
<%@page import="model.UserBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="font-regular/font-regular.css">
</head>
<body>
<form>
    <div class="panel panel-primary v-margin-xs">
        <div class="panel-heading font-regular font-lg">
		Menu List
        </div>
	<%	
		HttpSession httpSession = request.getSession();
		UserBean bean = (UserBean)session.getAttribute("user");
		if(bean.authenticate()){
	%>
		<h4 align="left">Welcome <% out.print(bean.getUserName());%>
		<div class="panel-body font-regular"><br><br>
                      
                <div class="col-md-12 v-margin-xs form-group">
	                <div class="editor-field col-md-4 row-no-padding ">
	                	<a href="controller?page=branch" class = "col-md-1  control-label row-no-padding">Branches</a> 
	                </div>
            	</div>
            	<div class="col-md-12 v-margin-xs form-group">
	                <div class="editor-field col-md-4 row-no-padding ">
	                	<a href="controller?page=branchgroup" class = "col-md-1  control-label row-no-padding">Branch Groups</a> 
	                </div>
            	</div>
            	
            	<div class="col-md-12 v-margin-xs form-group">
	                <div class="editor-field col-md-4 row-no-padding ">
	                	<a href="controller?page=item" class = "col-md-1  control-label row-no-padding">Item</a> 
	                </div>
            	</div>
            	
            	<div class="col-md-12 v-margin-xs form-group">
	                <div class="editor-field col-md-4 row-no-padding ">
	                	<a href="controller?page=itemgroup" class = "col-md-1  control-label row-no-padding">Item Group</a> 
	                </div>
            	</div>
            	
            	<div class="col-md-12 v-margin-xs form-group">
	                <div class="editor-field col-md-4 row-no-padding ">
	                	<a href="controller?page=itemrate" class = "col-md-1  control-label row-no-padding">Item Rate</a> 
	                </div>
            	</div>
            	
            	<div class="col-md-12 v-margin-xs form-group">
	                <div class="editor-field col-md-4 row-no-padding ">
	                	<a href="controller?page=guest" class = "col-md-1  control-label row-no-padding">Guest</a> 
	                </div>
            	</div>
            
	                  

			</div>
    	
	<%
		}
	%>
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<br><br><br><br><br>
	
	<div class="panel-footer panel-custom clearfix">
    		<div class="col-md-3">
	        	<input id="saveButton" type="submit" class="btn btn-primary btn-sm btn-space" value="S&#818;ave" tabindex="-1" />
	            <input id="resetButton" type="reset" class="btn btn-primary btn-sm btn-space" value="R&#818;eset" tabindex="-1" />
	            <a tabindex="-1" href="@Url.Action("Index", "Item", new { isRedirected = true })">
	            	<span class="glyphicon glyphicon-list-alt pull-left" style="margin-right: 10px; font-size: 1.75em; color: lightgray"></span>
	            </a>
        	</div>
        	
	        <div class="col-md-9 font-medium" style="text-align: right; color: lightgray">
	                &copy;2017, ICIT Pvt Ltd.
	        </div>
    	</div>
	</form>	
	
</body>
</html>
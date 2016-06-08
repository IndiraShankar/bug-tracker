<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Info</title>
<script type="text/javascript" src="resource/js/validateGenieForm.js"></script>
<link rel="stylesheet" type="text/css" 	href="resource/css/form.css">
</head>
<body>
    <jsp:include page="_menu.jsp" />
     
 
    <h3>Welcome : ${pageContext.request.userPrincipal.name}</h3>
 
 <div  class="form" >
	<form:form method="post" action="addGenie" commandName="genieForm" onsubmit="return validate()">
		
			
		 <br>
			Name: <form:input path="user.username" id="user" value="${pageContext.request.userPrincipal.name}"/> 
		<br>
			genieType  <form:select path="genieType"  id="genieType"  >
			<option value="">-Select-</option>
			<option value="LoginIssue">LoginIssue</option>
			<option value="networkIssue">networkIssue</option>
			<option value="laptopIssue">laptopIssue</option>
			<option value="browserIssue">browserIssue</option>
						</form:select>
		<br>
			Severity<form:select path="Severity" id="Severity" >
			<option value="">-Select-</option>
			<option value="Normal">Normal</option>
			<option value="critical">critical</option>
			<option value="Major">Major</option>
						</form:select>
			
		<br>
			Location <form:select path="location" id="location" >
			<option value="">-Select-</option>
			<option value="banglore">Banglore</option>
			<option value="Bhubaneshwar">Bhubaneshwar</option>
						</form:select>
			
		<br>
			status 	   <form:select path="status">
			<option value="open">open</option>
			<option value="closed">closed</option>
						</form:select>
		<br>
			Mobile number <form:input path="mobilenum" id="mobilenum" />
		<br>
			 Date(MM/dd/yyyy) <form:input path="raiseddate" id="raiseddate"  />
			
		<br>
			`<input type="submit" value="Submit" />


	</form:form>
	<b id="errorMsg" style="color: red"> </b>
</div>
  
</body>
</html>
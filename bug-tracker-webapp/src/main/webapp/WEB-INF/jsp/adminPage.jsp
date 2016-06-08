<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>${title}</title>
</head>
<body>
	<jsp:include page="_menu.jsp" />

	<h2>Admin Page</h2>

	<h3>Welcome : ${pageContext.request.userPrincipal.name}</h3>
	<h1>Genies raised till now</h1>
	<br>
	<table>
		<thead>
			<tr>
				<td>GenieType</td>
				<th>Location</th>
				<th>Mid</th>
				<th>Mobile Number</th>
				<th>RaisedDate</th>
				<th>Severity</th>
				<th>Status</th>
				<th>Assign to</th>
			</tr>
		</thead>
		<c:forEach items="${genies}" var="gen">
			<tr>
				<td>${gen.genieType}</td>
				<td>${gen.location}</td>
				<td>${gen.user.username}</td>
				<td>${gen.mobilenum}</td>
				<td>${gen.raiseddate}</td>
				<td>${gen.severity}</td>
				<td>${gen.status}</td>
				<td>
					<form action="assign">
						<input type="hidden" value="${gen.slno}" name="slno" /> <select
							id="associate" name="associate">
							<option value="${gen.assignedTo.username}">${gen.assignedTo.username}</option>
							<c:forEach items="${associateList}" var="associate">
								<option value="${associate.user.username}">${associate.user.username}</option>
							</c:forEach>
						</select> <input type="submit" value="assign" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
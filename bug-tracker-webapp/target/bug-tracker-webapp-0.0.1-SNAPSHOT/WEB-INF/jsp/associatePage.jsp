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
 
    <h3>Welcome : ${pageContext.request.userPrincipal.name}</h3>
<body>
	<table>
		<thead>
			<th>GenieType</th>
			<th>Location</th>
			<th>Mobile Number</th>
			<th>RaisedDate</th>
			<th>Severity</th>
			<th>Status</th>
			<th>RaisedBy</th>
			<th>edit</th>
		</thead>
		<tbody>
			<c:forEach items="${genieList}" var="gen">
				<tr>
					<td>${gen.genieType}</td>
					<td>${gen.location}</td>
					<td>${gen.mobilenum}</td>
					<td>${gen.raiseddate}</td>
					<td>${gen.severity}</td>
					<td>${gen.status}</td>
					<td>${gen.user.username}</td>
					<td><a href='edit?slno=${gen.slno}'>change the status</a></td>
					
			</c:forEach>
			</tr>
		</tbody>
	</table>
</body>    
</body>
</html>
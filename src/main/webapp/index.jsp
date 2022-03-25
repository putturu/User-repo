<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="UserDetaislServlet">getAllUsers</a>
<hr>
<h2>patient details</h2>
	<table border="1px">
		<tr>
			<th>user id</th>
			<th>user name</th>
			<th>user password</th>
			<th>user role</th>
		</tr>
		<c:forEach var="user" items="${user}">
			<tr>
				<td>user.userId</td>
				<td>user.userName</td>
				<td>user.password</td>
				<td>user.role</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
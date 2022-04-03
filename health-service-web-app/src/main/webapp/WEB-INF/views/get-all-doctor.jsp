<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2 align="center">Doctor List</h2>
		<form action="add-doctor-page">
			<div class="form-group" align="left">
				<button type="submit" class="btn btn-primary">Add Doctor</button>
			</div>
		</form>
		<table class="table">
			<thead>
				<tr>					
					<th>DoctorId</th>
					<th>Dname</th>
					<th>Specialization</th>
					<th>AvailableTimings</th>
					<th>Qualification</th>
					<th>Experience</th>										
					<th>Mobile</th>
					<th>Email</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
			    
				<c:forEach var="d" items="${doctorList}">
					<tr class="success">						
						<td>${d.doctorId}</td>
						<td>${d.doctorName}</td>
						<td>${d.specialization}</td>
						<td>${d.availableTiming}</td>
						<td>${d.qualification}</td>	
						<td>${d.experienceInYears}</td>	
						<td>${d.mobile}</td>
						<td>${d.email}</td>						
						<td><a href="edit-doctor?id=${d.doctorId}">edit</a></td>
						<td><a href="delete-doctor?id=${d.doctorId}">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
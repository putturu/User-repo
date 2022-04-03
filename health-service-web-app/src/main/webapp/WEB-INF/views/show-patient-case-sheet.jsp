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
		<h2 align="center">Patient Cases</h2>
		
		<table class="table">
			<thead>
				<tr>					
					
					<th>PatientCaseSheetId</th>
					<th>PatientName</th>
					<th>CaseSheetOpenDate</th>
					<th>CaseSheetCloseDate</th>
					<th>HostipalDetails</th>										
					<th>HealthStatistics</th>
					<th>Symptoms</th>
					<th>Prescription</th>
					<th>Diet</th>
					<th>Status</th>
					<th>PatientId</th>
					<th>DoctorId</th>
				</tr>
			</thead>
			<tbody>
			    
				<c:forEach var="p" items="${patientCaseSheetList}">
					<tr class="success">						
						<td>${p.patientCaseSheetId}</td>
						<td>${p.patientName}</td>
						<td>${p.caseSheetOpenDate}</td>
						<td>${p.caseSheetCloseDate}</td>
						<td>${p.hostipalDetails}</td>	
						<td>${p.healthStatistics}</td>	
						<td>${p.symptoms}</td>
						<td>${p.prescription}</td>
						<td>${p.diet}</td>
						<td>${p.status}</td>
						<td>${p.patientId}</td>
						<td>${p.doctorId}</td>						
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
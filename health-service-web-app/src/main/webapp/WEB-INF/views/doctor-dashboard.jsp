<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="bg-img">
<div class="content">
<header>DOCTOR PAGE</header>
<a align="center" size="30">Welcome To Doctor Page : ${username}</a><br><br>
<a href="GetPatientCaseSheetIdServlet">Get all Patient CaseSheets</a>
<a href="getAllDoctor">Get All Doctor Details</a><br><br>
<a href="getAllPatient">Get All Patient Details</a><br><br>
<a href="getdoctorid">Get Doctor Details</a><br><br>
<a href="logout" align="center">Logout</a>
</div>
</div>
</body>
</html>
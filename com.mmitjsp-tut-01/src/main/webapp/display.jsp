<%@page import="com.mmit.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
	<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
	<script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<!-- jQuery -->
	<script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<!--  font awesome -->
	<link rel="stylesheet" href="webjars/font-awesome/6.1.1/css/fontawesome.min.css">
</head>   
<body>
	<div class="container">
		<h3>Profile</h3>
		<%
			Student st = (Student) request.getAttribute("student");
			if(st == null) 	
				st = new Student();
		%>
		<table class="table">
			<tr>
				<td>Name</td>
				<td> <%= st.getName() %></td>
			</tr>
			<tr>
				<td>Email</td>
				<td> <%= st.getEmail() %></td>
			</tr>
			<tr>
				<td>Age</td>
				<td> <%= st.getAge() %></td>
			</tr>
			<tr>
				<td>Birthday</td>
				<td> <%= st.getBirthday() %></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td> <%= st.getGender() %></td>
			</tr>
			<tr>
				<td>Old Student</td>
				<td> <%= st.isOld_student() %></td>
			</tr>
			<tr>
				<td>Address</td>
				<td> <%= st.getAddress() %> </td>
			</tr>
		</table>
	</div>
</body>
</html>
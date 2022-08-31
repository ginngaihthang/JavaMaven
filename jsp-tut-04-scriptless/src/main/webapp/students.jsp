
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
<jsp:include page="common/res.jsp"></jsp:include>
	<style>
		body{
			background-color: #ebecf0;
		}
	</style>
</head>
<body>
	<!-- nav -->
	<jsp:include page="common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-3">
			<h3 class="col-10">Student<span class="text-danger">List</span></h3>
			<c:url value="/student-add" var="add"></c:url>
			<a href="${add}" class="btn btn-danger col mb-3"><i class="fa-solid fa-plus fa-lg"></i>Add Student</a>
			<hr />
			<table class="table table-success table-striped">
				<thead>
					<tr>
						<th>No</th>
						<th>Student Name</th>
						<th>Phone</th>
						<th>Email</th>
						<th>Batch</th>
						<th>Register Date</th>
						<th>Old Student</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${students}" var="s" varStatus="i">
					<tr>
						<td>${i.count}</td>
						<td>${s.name }</td>
						<td>${s.phone}</td>
						<td>${s.email}</td>
						<td>${s.batch}</td>
						<td>${s.registerDate}</td>
						<td>${s.oldStudent}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!--footer -->
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
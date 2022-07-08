<%@page import="com.nmit.entry.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%= request.getAttribute("title") %></title>
<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
	<!-- nav -->
	<jsp:include page="common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-3">
			<h3 class="col-10">Student List</h3>
			<a href="student-add" class="btn btn-primary col mb-3"><i class="fa-solid fa-plus fa-lg"></i>Add Student</a>
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
					<%
						List<Student> list = (ArrayList<Student>) session.getAttribute("students");
						if(list == null)
							list = new ArrayList<>();
						for(int i = 0;i <list.size();i++) {
							Student temp = list.get(i);
							%>
								<tr>
									<td><%= (i+1) %></td>
									<td><%= temp.getName() %></td>
									<td><%= temp.getPhone() %></td>
									<td><%= temp.getEmail() %></td>
									<td><%= temp.getBatch() %></td>
									<td><%= temp.getRegisterDate() %></td>
									<td><%= temp.isOldStudent() %></td>
								</tr>
							<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<!--footer -->
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
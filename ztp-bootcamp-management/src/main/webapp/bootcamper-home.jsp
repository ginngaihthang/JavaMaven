<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
	<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-3">
			<h3 class="col-10">All Boocamper</h3>
			<c:url value = "/add-bootcamper" var="add"></c:url>
			<a href="${add}" class="btn btn-primary col">Add Bootcamper</a>
		</div>
		<hr />
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					 <th>Id</th>
					 <th>Bootcamper Name</th>
					 <th>Batch Name</th>
					 <th>Email</th>
					 <th>Phone</th>
					 <th>Action</th>
				</tr>
			</thead>
			<tbody>
				<!--bootcamper list -->
				<c:forEach items="${bootcampers}" var="b" varStatus="i">
					<tr>
						<td>${i.count}</td>
						<td>${b.name}</td>
						<td>${b.batch.name}</td>
						<td>${b.email}</td>
						<td>${b.phone }</td>
						<td>
						<c:url value="/edit-bootcamper" var="edit">
							<c:param name="id">${b.id}</c:param>
						</c:url>
						<a href="${edit}" class="btn btn-outline-success btn-sm text-white">Edit</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
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
			<h3 class="col-10">All Level</h3>
			<c:url value = "/add-level" var="add"></c:url>
			<a href="${add}" class="btn btn-primary col">Add Level</a>
		</div>
		<hr />
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					 <th>Id</th>
					 <th>Level name</th>
					 <th>Duration(Month)</th>
					 <th>Fees</th>
					 <th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${levels}" var="lvl">
					<tr>
						<td>${lvl.id}</td>
						<td>${lvl.name}</td>
						<td>${lvl.duration}</td>
						<td>${lvl.fees}</td>
						<td>
							<c:url value="/edit-level" var="edit">
								<c:param name="id">${lvl.id}</c:param>
							</c:url>
							<a href="${edit}" class="btn btn-outline-success text-white">Edit</a>
							<c:url value="/batches" var="batch" >
								<c:param name="levelId">${lvl.id}</c:param>
							</c:url>
							<a href="${batch}" class="btn btn-outline-info btn-sm text-white">Batch(${lvl.totalBatch})</a>
							<c:url value="/courses" var="course">
								<c:param name="levelId">${lvl.id}</c:param>
							</c:url>
							<a href="${course}" class="btn btn-outline-secondary btn-sm text-white">Course(${lvl.totalCourse})</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
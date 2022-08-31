<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title} |${batch.id == 0 ? 'Add': 'Edit'}</title>
	<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-3">
			<h3 class="col-10">${batches.id == 0 ? 'Add': 'Edit'} Batch</h3>
			<c:url value = "/batches" var="back"></c:url>
			<a href="${back}" class="btn btn-primary col">Back</a>
		</div>
		<hr />
		<c:url value="/add-batch" var="save"></c:url>
		<form action="${save}" class="form col-6 offset-3"  method="post">
			<input type="hidden" name="batchId" class="form-control"  value="${batch.id}"/>
			<div class="mb-3 ">
				<label for="" class="form-label">Level</label>
				<select name="level" id="" class="form-select">
				<c:forEach items="${levels}" var="l">
					<option value="${l.id}">${l.name}</option>
				</c:forEach>
				
				</select>
			</div>
			<div class="mb-3">
				<label for="" class="form-label">BatchName</label>
				<input value="${batch.name} " type="text" name="name" class="form-control" required="required"/>
			</div>
			
			
			<div class="mb-3">
				<label for="" class="form-label">StartDate</label>
				<input value="${batch.startDate}" type="date" name="startDate" class="form-control" required="required" placeholder="Enter fees"/>
			</div>
			<div class="mb-3">
				<button class="btn btn-success" type="submit">Save</button>
				<button class="btn btn-danger" type="reset">Clear</button>
			</div>
		</form>
	</div>
	
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
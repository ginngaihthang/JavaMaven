<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title} |${course.id == 0 ? 'Add': 'Edit'}</title>
	<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-3">
			<h3 class="col-10">${course.id == 0 ? 'Add': 'Edit'} Course</h3>
			<c:url value = "/courses" var="back"></c:url>
			<a href="${back}" class="btn btn-primary col">Back</a>
		</div>
		<hr />
		<c:url value="/add-course" var="save"></c:url>
		<form action="${save}" class="form col-6 offset-3"  method="post">
			<input type="hidden" name="courseId" class="form-control"  value="${course.id}"/>
			<div class="mb-3">
				<label for="" class="form-label">Level</label>
				<select name="level" id="" class="form-select">
					<c:forEach items="${levels}" var="l" >
						<option value="${l.id}">${l.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3">
				<label for="" class="form-label">Name</label>
				<input value="${course.name}" type="text" name="name" class="form-control" required="required" />
			</div>
			<div class="mb-3">
				<label for="" class="form-label">Content</label>
				<textarea id="summernote" name="content"  class="form-control" >${course.content}</textarea>
			</div>
			
			<div class="mb-3">
				<button class="btn btn-success" type="submit">Save</button>
				<button class="btn btn-danger" type="reset">Clear</button>
			</div>
		</form>
	</div>
	<script >
		$(document).ready(function() {
			$('#summernote').summernote();
		})
		
	</script>
	
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
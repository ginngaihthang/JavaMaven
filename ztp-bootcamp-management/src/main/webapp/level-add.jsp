<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title} |${level.id == 0 ? 'Add': 'Edit'}</title>
	<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-3">
			<h3 class="col-10">${level.id == 0 ? 'Add': 'Edit'} Level</h3>
			<c:url value = "/levels" var="back"></c:url>
			<a href="${back}" class="btn btn-primary col">Back</a>
		</div>
		<hr />
		<c:url value="/add-level" var="save"></c:url>
		<form action="${save}" class="form col-6 offset-3"  method="post">
			<input type="hidden" name="levelId" class="form-control"  value="${level.id}"/>
			<div class="mb-3">
				<label for="" class="form-label">Name</label>
				<input value="${level.name} " type="text" name="name" class="form-control" required="required"/>
			</div>
			<div class="mb-3">
				<label for="" class="form-label">Duration(Month)</label>
				<input value="${level.duration}" type="number" name="duration" class="form-control" required="required" />
			</div>
			<div class="mb-3">
				<label for="" class="form-label">Fees</label>
				<input value="${level.fees}" type="number" name="fee" class="form-control" required="required" placeholder="Enter fees"/>
			</div>
			<div class="mb-3">
				<button class="btn btn-success btn-add" type="submit">Save</button>
				<button class="btn btn-danger" type="reset">Clear</button>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.btn-add').click(function() {
				Swal.fire(
						  'Good job!',
						  'You clicked the button!',
						  'success'
						)
			})
		})
		
	</script>
	
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
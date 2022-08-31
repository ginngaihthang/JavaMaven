<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title} |${bootcamper.id == 0 ? 'Add': 'Edit'}</title>
	<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-3">
			<h3 class="col-10">${bootcmaper.id == 0 ? 'Add': 'Edit'} Bootcamper</h3>
			<c:url value = "/bootcampers" var="back"></c:url>
			<a href="${back}" class="btn btn-primary col">Back</a>
		</div>
		<hr />
		<c:url value="/add-bootcamper" var="save"></c:url>
		<form action="${save}" class="form col-6 offset-3"  method="post">
			<input type="hidden" name="bootId" class="form-control"  value="${bootcamper.id}"/>
			<div class="mb-3">
				<label for="" class="form-label">Batch</label>
				<select name="batch" class="form-select">
					<c:forEach items="${batches}" var="b" >
						<option value="${b.id}">${b.name}</option>
					</c:forEach>
				</select>
				
			</div>
			<div class="mb-3">
				<label for="" class="form-label">Name</label>
				<input id="name" value="${bootcamper.name}" type="text" name="name" class="form-control"  placeholder="Enter Name"/>
			</div>
			
			<div class="mb-3">
				<label for="" class="form-label">Email</label>
				<input id="email" value="${bootcamper.email}" type="email" name="email" class="form-control" placeholder="Enter email"/>
			</div>
			<div class="mb-3">
				<label for="" class="form-label">Phone</label>
				<input id="phone" value="${bootcamper.phone}" type="number" name="phone" class="form-control"  placeholder="Enter Phone"/>
			</div>
			<div class="mb-3">
				<button class="btn btn-success btn-add" type="submit">Save</button>
				<button class="btn btn-danger" type="reset">Clear</button>
			</div>
		</form>
	</div>
	<script type="text/javascript">
	/* $(document).ready(function() {
		$('.form').submit(function(evt) {
			alert('hi');
		});
	}); */
	$(document).ready(function() {
		$('.form').submit(function(event) {
			let n = $('#name').val();
			let e = $('#email').val();
			let p = $('#phone').val();
				
			  if(n == '') {
				  //alert("Please fill up name")
				Swal.fire(
						  'Please Fill Up Name!',
						  'You clicked the button!',
						  'Fail'
						)
				event.preventDefault(); 
				} 
			  else if(e == '') {
				  Swal.fire(
						  'Please Fill Up Email!',
						  'You clicked the button!',
						  'Fail'
						)
				event.preventDefault();
			}  
			  else if(p == '') {
				  Swal.fire(
						  'Please Fill Up Phone!',
						  'You clicked the button!',
						  'Fail'
						)
				event.preventDefault();
			}  
			  else{
				  Swal.fire(
						  'Good Job!',
						  'You clicked the button!',
						  'Success'
						)
			}
						
		})
	}) 
	</script>
	
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
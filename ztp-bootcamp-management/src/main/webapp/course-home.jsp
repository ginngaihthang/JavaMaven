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
			<h3 class="col-10">All Course</h3>
			<c:url value = "/add-course" var="add"></c:url>
			<a href="${add}" class="btn btn-primary col">Add Course</a>
		</div>
		<hr />
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					 <th>Id</th>
					 <th>Course name</th>
					 <th>Level Name</th>
					 <th>Create At</th>
					 <th>Update At</th>
					 <th>Action</th>
				</tr>
			</thead>
			<tbody>
				<!--batch list -->
				<c:forEach items="${courses}" var="c" varStatus="i">
					<tr>
						<td>${i.count}</td>
						<td>${c.name}</td>
						<td>${c.level.name}</td>
						<td>${c.created_at}</td>
						<td>${c.updated_at}</td>
						<td>
							<c:url value="/edit-course" var="edit">
								<c:param name="id">${c.id}</c:param>
							</c:url>

							<a href="${edit}" class="btn btn-outline-success text-white btn-sm">Edit</a>
							<a href="#" class="btn btn-outline-danger text-white btn-sm btn-remove" data-id="${c.id}">
								Remove
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.btn-remove').click(function() {
				let levelId = $(this).data('id')
				//alert(levelId)
				//if(confirm('Are you sure to delete?')) {
				//	window.location.href = "delete-course?id=" + levelId;
				//}
				Swal.fire({
					  title: 'Are you sure?',
					  text: "You won't be able to revert this!",
					  icon: 'warning',
					  showCancelButton: true,
					  confirmButtonColor: '#3085d6',
					  cancelButtonColor: '#d33',
					  confirmButtonText: 'Yes, delete it!'
					}).then((result) => {
					  if (result.isConfirmed) {
						  window.location.href = "delete-course?id=" + levelId;
					    Swal.fire(
					      'Deleted!',
					      'Your file has been deleted.',
					      'success'
					    )
					  }
					})
			})
		}) 
	</script>
	
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
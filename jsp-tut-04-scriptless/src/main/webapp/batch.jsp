<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
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
		input[type="text"],input[type="number"],input[type="email"],input[type="date"],select, textarea{
			border: none;
			outline: none;
			text-shadow: 1px 1px 0 #fff;
			transition: all 0.2s ease-in-out;
			box-shadow: inset 2px 2px 5px #babecc, inset -5px -5px 10px #fff;
			background-color: #ebecf0;
			border-radius: 15px;
		}
		.btn{
			color: #61677c;
			font-weight: bold;
			box-shadow: -2px -2px 5px #fff, 2px 2px 5px #babecc;
			transition: all 0.2s ease-in-out;
			sursor: pointer;
			font-weight: 600;	
			width: 49%;
		}
		.btn:hover {
			box-shadow:-5px -5px 20px #fff, 5px 5px 20px #babecc;
			
		}
		.btn:active{
			box-shadow: inset 1px 1px 2px #babecc, inset -1px -1px 2px #fff;
		}
	</style>
</head>
<body>
<!-- navagation -->
	<jsp:include page="common/nav.jsp"></jsp:include>
	
	<div class="container">
		<div class="row mt-2">
			<h3>Batch<span class="text-danger">List</span></h3>
		</div>
		<hr />
		<div class="row">
			<div class="col-4">
			<c:url value="add-batch" var="add"></c:url>
			<form action="${add}" class="form" method="post">
			<div class="mt-3">
				<label for="" class="form-label">Batch Name</label>
				<input type="text" class="form-control" name="batchName" placeholder="Batch Name" required="required" />
			</div>
			<div class="mt-3">
				<label for="" class="form-label">Start Date</label>
				<input type="date" class="form-control" name="startDate" required="required" />
			</div>
			<div class="row mt-4">
				<div class="col-6">
					<button class="btn w-100" type="submit">Create</button>
				</div>
				<div class="col-6">
					<button class="btn w-100" type="reset">Clear</button>
				</div>
			</div>
		</form>
		</div>
		<div class="col-1"></div>
		<div class="col-7 mt-3">
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<td>No</td>
						<td>Batch Name</td>
						<td>Start Date</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${batches}" var="b" varStatus="i">
					<tr>
						<td>${i.count}</td>
						<td>${b.name }</td>
						<td>${b.start_date}</td>
									
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
		</div>
	
	<!-- footer -->
	<jsp:include page="common/footer.jsp"></jsp:include>
	
</body>
</html>
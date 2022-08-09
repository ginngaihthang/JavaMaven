<%@page import="java.util.ArrayList"%>
<%@page import="com.nmit.entry.Batch"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%= request.getAttribute("title") %></title>
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
	<!-- nav -->
	<jsp:include page="common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-2">
			<h3 class="col-10">Add New <span class="text-danger">Student</span></h3>
		</div>
		<hr />
		<form action="add-student" class=" col-5" method="post">
			<div class="mb-3 ">
				<label for="" class="form-label">Student Name</label>
				<input type="text" class="form-control" name="stdName" required="required"/>
			</div>
			<div class="mb-3 ">
				<label for="" class="form-label">Phone</label>
				<input type="number" class="form-control" name="phone" required="required"/>
			</div>
			<div class="mb-3 ">
				<label for="" class="form-label">Email</label>
				<input type="email" class="form-control" name="email" required="required"/>
			</div>
			<div class="mb-3 ">
				<label for="" class="form-label">Choose Batch</label>
				<select name="batchs" id="" class="form-select">
				<%
					List<Batch> list = (ArrayList<Batch>) application.getAttribute("batches");
					if(list == null) 
						list = new ArrayList<>();
					for(Batch b: list) {
						%>
							<option value="<%= b.getName() %>"><%= b.getName() %></option>
						<%
					}		
				%>
				
				</select>
			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-cieck-input" name="old" id="std"/>
				<label for="std" class="form-check-label">Old Student</label>
			</div>
			<div class="row">
				<div class="col-6">
					<button class="btn w-100" type="reset">Clear</button>
				</div>
				<div class="col-6">
					<button class="btn  w-100" type="submit">Save</button>
				</div>
			</div>
		</form>
	</div>
	<!-- footer -->
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
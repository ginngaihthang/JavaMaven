<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bootstrap</title>
<!--  Bootstrap -->
	<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
	<script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<!-- jQuery -->
	<script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<!--  font awesome -->
	<link rel="stylesheet" href="webjars/font-awesome/6.1.1/css/fontawesome.min.css">
	<style type="text/css">
		*{
		margin: 0;
		pading: 0;
		box-sizing: border-box;
		}
		body{
			display: flex;
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
	<div class="container">
		<h2 class="mt-2">Register Form</h2>
		<hr>
		<div class="row">
			<div class="col-4">
			</div>
			<div class="col-4 align-items-center">
				<form action="register" method="post" >
					<div class="mb-4">
						<input name="username" type="text" class="form-control" placeholder="user name">
					</div>
					<div class="mb-4">

						<input name="email"  type="email" class="form-control" placeholder="email" required="required">
					</div>
					<div class="mb-4">

						<input name="age"  type="number" class="form-control" placeholder="age" required="required">
					</div>
					<div class="mb-4">

						<input name="dob" type="date" class="form-control" placeholder="Birthday" required="required">
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Region</label>
						<select name="region" class="gorm-select">
							<option value="mandalay" >Mandalay</option>
							<option value="yangon" >Yangon</option>
							<option value="sagaing" >Sagaing</option> 
						</select>
					</div>
					<div class=" mb-3">
						
							<div class="form-check p-0">
								<span>Gender</span>
								<input name="gender" value="male" type="radio" class="form-ckeck-input"  checked="checked">
								<label for="male" class="form-check-label">Male</label>
									
								<input name="gender" value="female" type="radio" class="form-ckeck-input"  checked="checked">
								<label for="female" class="form-check-label">Female</label>
							</div>	
					</div>
					<div class="mb-4">
						<textarea name="address" rows="4" cols="50%" placeholder="Enter address" style=" padding: 10px;"></textarea>
					</div>
					<div class="mb-4 form-check ps-5">
						
						<input name="old_student" type="checkbox" class="form-check-input" id="chk">
						<label for="chk" class="form-ckeck-label" >Old Student</label>
					</div>
					<div class="mb-4">
						<button class="btn" type="reset">Reset</button>
						<button class="btn" type="submit">Register</button>
					</div>
					<div class="col-4"></div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
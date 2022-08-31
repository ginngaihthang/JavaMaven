<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Without EL</h3>
	<form action="">
		<table>
			<tr>
			<td>Username</td>
			<td>
				<input type="text" name="uname" value="${param.uname}"/>
			</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>
				<input type="email" name="email" value="${param.email}"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit"  />
			</td>
		</tr>
		</table>
	</form>
	<hr />
	
		<div style="display:${(param.uname =='' or empty param.email) ? 'none': 'block'}">
			<h3>Result</h3>
		<h3>Name: ${param.uname}</h3>
		<h3>Email: ${param.email }</h3>
		</div>
	

</body>
</html>
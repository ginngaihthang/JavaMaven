<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%= request.getAttribute("title") %></title>
	<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="mt-5 pt-5">
			<h2 class="text-primary text-center">Welcome From Zero To Pro Bootcamp</h2>
			<h3 class="text-primary text-center">MMIT</h3>
		</div>
	</div>
	
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
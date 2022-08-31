<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--  Bootstrap -->
	<c:url var="bsCss" value="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"></c:url>
	<c:url var="bsJs" value="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></c:url>
	<c:url var="jqJs" value="/webjars/jquery/3.6.0/jquery.min.js"></c:url>
	<c:url var="faCss" value="/webjars/font-awesome/6.1.1/css/fontawesome.min.css"></c:url>
	<c:url var="faJs" value="/webjars/font-awesome/6.1.1/js/fontawesome.min.js"></c:url>
	<c:url var="summerCss" value="webjars/summernote/0.8.10/summernote.css"></c:url>
	<c:url var="summerJs" value="webjars/summernote/0.8.10/summernote.min.js"></c:url>
	
	<link rel="stylesheet" href="${bsCss}" />
	<script type="text/javascript" src="${bsJs}"></script>
	<!-- jQuery -->
	<script type="text/javascript" src="${jqJs}"></script>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<!--  font awesome -->
	<link rel="stylesheet" href="${faCss}">
	<script type="text/javascript" src="${faJs}"></script>
	<!--  summer note -->
	<link rel="stylesheet" href="${summerCss}" />
	<script type="text/javascript" src="${summerJs}"></script>

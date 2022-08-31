<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
      	<c:url value="levels" var="level"></c:url>
      	<c:url value="batches" var="batch"></c:url>
      	<c:url value="courses" var="course"></c:url>
      	<c:url value="bootcampers" var="bootcamp"></c:url>
        <li class="nav-item">
          <a class="nav-link ${empty title ? 'active' : '' }" aria-current="page" href="<%= request.getContextPath()%>">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link ${title eq 'Level'  ? 'active' : '' }"  href="${level}">Level</a>
        </li>
        <li class="nav-item">
          <a class="nav-link ${title eq 'Batch' ? 'active' : '' }" href="${batch}">Batch</a>
        </li>
        <li class="nav-item">
          <a class="nav-link ${title eq 'Course' ? 'active' : '' }" href="${course}">Course</a>
        </li>
        <li class="nav-item">
          <a class="nav-link ${title eq 'Bootcamper' ? 'active' : '' }" href="${bootcamp}">Bootcamper</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>REGISTRATION</title>
	<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/css/signin.css" />" rel="stylesheet">
</head>
<body>

	<div class="container">
		<c:if test="${password == null}">
		<form class="form-signin" action="registration" method="post">
			<h2 class="form-signin-heading">Registration</h2>
			<c:if test="${error != null}">
				<div>
					<p>${error}</p>
				</div>
			</c:if>
			<label for="phone" class="sr-only">Phone number</label>
			<input type="text" id="phone" name="phone" class="form-control" placeholder="Phone number" required="" autofocus="">

			<br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Registration</button>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		</c:if>
		<c:if test="${password != null}">
		<div class="row marketing">
			<div class="col-lg-12">
				<h4>CONGRADULATION</h4>
				<p>USERNAME  ${username}</p>
				<p>PASSWORD  ${password}</p>
			</div>
		</div>
		</c:if>

	</div>
</body>
</html>
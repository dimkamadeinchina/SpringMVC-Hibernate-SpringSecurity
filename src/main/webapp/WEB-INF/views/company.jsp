<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>COMPANY PAGE</title>
	<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/css/signin.css" />" rel="stylesheet">
</head>
<body>

	<div class="container">
			<form class="form-signin" method="post" action="createRecord">
			<h2 class="form-signin-heading">${company.name}</h2>
			<label for="phoneNumber" class="sr-only"></label>
			<input type="text" id="phoneNumber" name="phoneNumber" class="form-control" placeholder="Phone number" required="" autofocus="">

			<label for="amount" class="sr-only">Amount</label>
			<input type="number" min="${company.minValue}" max="${company.maxValue}" value="${company.minValue}" id="amount" name="amount" class="form-control"required="">
			<br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">PAY</button>
				<input type="hidden" name="id_company" value="${company.id}" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>
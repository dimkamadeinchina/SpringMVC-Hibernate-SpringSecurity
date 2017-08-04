<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<html>
<head>
	<title>HISTORY PAGE</title>
	<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/css/jumbotron-narrow.css" />" rel="stylesheet">
	<link href="<c:url value="/css/justified-nav.css" />" rel="stylesheet">
</head>

<div class="container">
	<div class="header clearfix">
		<nav>
			<ul class="nav nav-pills pull-right">
		<li role="presentation"><form:form action="/logout"><div><button type="submit">Logout</button></div></form:form></li>
			</ul>
		</nav>
		<h3 class="text-muted">Hello, ${user.username}. Your balance = ${user.balance}</h3>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th data-toggle="modal" data-target=".bs-example-modal-sm">Company</th>
				<th>Amount</th>
				<th>Date</th>
				<th></th>
			</tr>
		</thead>
	</table>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>Phone number</th>
				<th>Company</th>
				<th>Amount</th>
				<th>Date</th>
			</tr>
		</thead>
		<c:if test="${not empty records}">
		<tbody>
			<c:forEach items="${records}" var="record">
				<tr>
					<th>${record.id}</th>
					<th>${record.phoneNumber}</th>
					<th>${record.company.name}</th>
					<th>${record.amount}</th>
					<th>${record.date}</th>
				</tr>
			</c:forEach>
		</tbody>
		</c:if>
	</table>



	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<form class="form-signin" method="get" action="/user/history/filter">

					<div class="btn-group" data-toggle="buttons">
						<c:forEach items="${companies}" var="company">
						<label class="btn btn-primary">
							<input type="radio" name="company" value="${company.id}" id="${company.id}" autocomplete="off" checked> ${company.name}
						</label>
						</c:forEach>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">FILTER IT</button>
				</form>
			</div>
		</div>
	</div>


</div>
	<script src="<c:url value="/js/jquery.js" />"></script>
	<script src="<c:url value="/js/bootstrap.min.js" />"></script>
</body>
</html>
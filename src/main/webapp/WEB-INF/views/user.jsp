<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<html>
<head>
	<title>INDEX PAGE</title>
	<link href="<c:url value="css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="css/jumbotron-narrow.css" />" rel="stylesheet">
	<link href="<c:url value="css/justified-nav.css" />" rel="stylesheet">
</head>

<div class="container">
	<div class="header clearfix">
		<nav>
			<ul class="nav nav-pills pull-right">
				<li role="presentation"><form:form action="logout"><div><button type="submit">Logout</button></div></form:form></li>
			</ul>
		</nav>
		<h3 class="text-muted">Hello, ${user.username}. Your balance = ${user.balance}</h3>
	</div>

	<div class="masthead">
		<nav>
			<ul class="nav nav-justified">
				<c:if test="${not empty companies}">
					<c:forEach items="${companies}" var="company">
					<li><a href="/user/company?id=<c:out value='${company.id}'/>"><c:out value="${company.name}"/></a></li>
					</c:forEach>
				</c:if>
			</ul>
		</nav>
	</div>

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
			<c:if test="${records.size() == 3}">
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th><a href="/user/history">see all</a></th>
				</tr>
			</c:if>
		</tbody>
		</c:if>
	</table>

</div>

</body>
</html>
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
	<link href="<c:url value="/css/bootstrap-slider.css" />" rel="stylesheet">
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
				<th data-toggle="modal" data-target=".bs-example-modal-sm.company">Company</th>
				<th data-toggle="modal" data-target=".bs-example-modal-sm.amount">Amount</th>
				<th>Date</th>
				<th><a href="/user/history">reset</a></th>
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


	<!-- modals -->
	<div class="modal fade bs-example-modal-sm company" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<form class="form-signin" method="get" action="/user/history/filterByCompany">

					<div class="btn-group margin-bottom-15" data-toggle="buttons">
						<c:forEach items="${companies}" var="company" varStatus="stat">
								<label class="btn btn-primary ${stat.first ? 'active' : ''}"  >
									<input type="radio" ${stat.first ? 'checked' : ''}  name="company" value="${company.id}" id="${company.id}" autocomplete="off"> ${company.name}
								</label>
						</c:forEach>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">FILTER IT</button>
				</form>
			</div>
		</div>
	</div>


	<div class="modal fade bs-example-modal-sm amount" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<form class="form-signin" method="get" action="/user/history/filterByAmount">
					<div class="margin-bottom-15 well">
						Filter by amount interval: <br>
						<b>${amounts.get("min")}</b>
						<input id="ex2" type="text" class="span2" name="amount" value="" data-slider-min="${amounts.get("min")}" data-slider-max="${amounts.get("max")}" data-slider-step="10" data-slider-value="[${amounts.get("min")},${amounts.get("max")}]"/>
						<b>${amounts.get("max")}</b>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">FILTER IT</button>
				</form>
			</div>
		</div>
	</div>
	<!-- end modals -->
</div>
	<script src="<c:url value="/js/jquery.js" />"></script>
	<script src="<c:url value="/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/js/bootstrap-slider.js" />"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#ex2").slider({});
		});
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>COMPANY PAGE</title>
	<link href="<c:url value="css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="css/signin.css" />" rel="stylesheet">
</head>
<body>

	<div class="container">
		<c:if test="${company != null}">
			<h3>${company.name}</h3>
			<h3>${company.minValue}</h3>
			<h3>${company.maxValue}</h3>
		</c:if>
		<form class="form-signin" action="login" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<c:if test="${param.error != null}">
				<div>
					<p>Authentication Failed : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div>
					<p>You have been logged out successfully.</p>
				</div>
			</c:if>
			<label for="username" class="sr-only">Login</label>
			<input type="text" id="username" name="username" class="form-control" placeholder="Login" required="" autofocus="">

			<label for="password" class="sr-only">Password</label>
			<input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
			<br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		${messageID}
		${messageID}
		${messageID}

	</div>
</body>
</html>
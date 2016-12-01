<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<link rel="stylesheet"
	href="https://necolas.github.io/normalize.css/5.0.0/normalize.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.css">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
</head>
<body>

	<header>
		<div class="container"></div>
	</header>
	<div id="main">
		<div class="container">
			<form:form action="loginData" method="POST" commandName="loginForm">
				<div class="form-group">
					<label><b>User Name</b></label>
					<form:input path="userName" />
				</div>

				<div class="form-group">
					<label><b>Password</b></label>
					<form:input path="password" />
				</div>

				<input type="submit" value="Send">
				<button id="myButton" type="button">Register</button>
			</form:form>
		</div>
	</div>
	<footer>
		<div class="container">
			<div class="copywrite">&copy; copyright 2016, Simple Login</div>
		</div>
	</footer>
	<script src="<c:url value="/resources/js/js.js" />"></script>
</body>
</html>
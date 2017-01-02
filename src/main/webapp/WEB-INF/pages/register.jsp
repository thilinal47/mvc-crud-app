<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet"
	href="https://necolas.github.io/normalize.css/5.0.0/normalize.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.css">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
</head>
<body>
	<form:form method="POST" action="sendData" commandName="registerForm">
		<div class="form-group">
			<label><b>User Name</b></label>
			<form:input path="userName" />
		</div>

		<div class="form-group">
			<label><b>Password</b></label>
			<form:input path="password" />
		</div>

		<%-- <div class="form-group">
			<label><b>Re Enter Password</b></label>
			<form:input path="passwordtwo" />
		</div> --%>

		<input type="submit" value="Register">
	</form:form>
</body>
</html>
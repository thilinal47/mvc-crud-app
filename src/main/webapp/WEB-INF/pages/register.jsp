<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
		<input type="submit" value="Send">
	</form:form>
</body>
</html>
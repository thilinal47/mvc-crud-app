<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>List of Employees</h2>
	<table>
		<tr>
			<td>NAME</td>
			<td>Joining Date</td>
			<td>Salary</td>
			<td>SSN</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.name}</td>
				<td>${employee.joiningDate}</td>
				<td>${employee.salary}</td>
				<td>${employee.ssn}</td>
				<td><a href="<c:url value='/delete/${employee.id}'/>">delete</a></td>
				<td><a href="<c:url value='/edit/${employee.id}'/>">edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="<c:url value='/add' />">Add New Employee</a>
</body>
</html>
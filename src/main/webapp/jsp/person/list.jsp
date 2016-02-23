<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person List</title>
</head>
<body>
	<table>
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Age</td>
			<td>BirthDay</td>
		</tr>
		<c:forEach items="${list}" var="person">
			<tr>
				<td>${person.id}</td>
				<td>${person.name}</td>
				<td>${person.age}</td>
				<td>${person.dobStr}</td>
				<td><a href="view?id=${person.id}">View</a></td>
				<td><a href="edit?id=${person.id}">Edit</a></td>
				<td><form action="delete?id=${person.id}" method="post">
						<input type="submit" value="Delete">
					</form></td>
			</tr>
		</c:forEach>
	</table>
	<a href="add">Add a new person</a>
</body>
</html>
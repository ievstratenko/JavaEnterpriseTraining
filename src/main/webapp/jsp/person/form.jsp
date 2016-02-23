<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person ${(person.id != null) ? 'Edit' : 'Add'} Form</title>
</head>
<body>
	<form action="save?id=${person.id}" method="post">
		<label for="name">Name</label> <input id="name" name="name"
			value="${person.name}" />
		<br />
		<label for="age">Age</label> <input id="age" name="age" type="number"
			value="${person.age}" />
		<br />
		<input type="submit" />
	</form>
	<a href="list">List</a>
</body>
</html>
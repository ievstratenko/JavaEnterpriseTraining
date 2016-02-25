<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person View</title>
</head>
<body>
	<label for="id">Id :</label>
	<span id="id">${person.id}</span>
	<br />
	<label for="name"><s:message code="name" /> :</label>
	<span id="name">${person.name}</span>
	<br />
	<label for="age">Age :</label>
	<span id="age">${person.age}</span>
	<br />
	<label for="dob">Birthday :</label>
	<span id="dob">${person.dobStr}</span>
	<br />
	<a href="list">List(${personCount})</a>
	<br />
	${test}
</body>
</html>
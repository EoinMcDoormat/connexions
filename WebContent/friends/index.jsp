<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>friends</title>
</head>
<body>
	<h1>friends</h1>
		<c:forEach var="friends" items="${friends}">
		<h4>
			<c:out value="${friends.firstName}" />
			<c:out value="${friends.lastName}" />			
		</h4>
		<c:out value="${friends.position}" />
		<c:out value="${friends.institution}" /><br/>
		</c:forEach>
	
	<form action="users" method="post">
		<input type="submit" name="action" value="logout" />
	</form>
</body>
</html>
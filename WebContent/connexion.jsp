<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>conneXions</title>
</head>
<body>
	<h1>conneXions</h1>
	<table>
		<c:forEach items="${requests}" var="conn">
			<tr>
				<td>${conn.firstName}</td>
				<td>${conn.lastName}</td>
				<td><form action="connexions" method="post">
						<button name="accept" type="submit" value="${conn.id}">accept conneXion</button>
					</form></td>
					<td><form action="connexions" method="post">
						<button name="reject" type="submit" value="${conn.id}">reject conneXion</button>
					</form></td>
			</tr>
		</c:forEach>
		<c:forEach items="${search}" var="conn">
			<tr>
				<td>${conn.firstName}</td>
				<td>${conn.lastName}</td>
				<td><form action="connexions" method="post">
						<button name="add" type="submit" value="${conn.id}">add conneXion</button>
						</form></td>
			</tr>
		</c:forEach>
		<c:forEach items="${connexions}" var="conn">
			<tr>
				<td>${conn.firstName}</td>
				<td>${conn.lastName}</td>
				<td><form action="connexions" method="post">
						<button name="remove" type="submit" value="${conn.id}">remove conneXion</button>
					</form></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="home.jsp">home</a>
	</p>
	<form action="users" method="post">
    <input type="submit" name="action" value="logout" />
</form>
</body>
</html>

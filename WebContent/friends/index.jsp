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
	<table>
		<c:forEach items="${requests}" var="friend">
			<tr>
				<td>${friend.firstName}</td>
				<td>${friend.lastName}</td>
				<td><form action="friends" method="post">
						<button name="accept" type="submit" value="${friend.id}">accept friend</button>
					</form></td>
					<td><form action="friends" method="post">
						<button name="reject" type="submit" value="${friend.id}">reject friend</button>
					</form></td>
			</tr>
		</c:forEach>
		<c:forEach items="${search}" var="friend">
			<tr>
				<td>${friend.firstName}</td>
				<td>${friend.lastName}</td>
				<td><form action="friends" method="post">
						<button name="add" type="submit" value="${friend.id}">add friend</button>
						</form></td>
			</tr>
		</c:forEach>
		<c:forEach items="${friends}" var="friend">
			<tr>
				<td>${friend.firstName}</td>
				<td>${friend.lastName}</td>
				<td><form action="friends" method="post">
						<button name="remove" type="submit" value="${friend.id}">remove friend</button>
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

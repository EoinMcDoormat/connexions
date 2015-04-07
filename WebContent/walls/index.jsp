<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Home</title>
</head>
<body>
	<h1>Home</h1>
	Welcome ${sessionScope.currentSessionUser.username}
	<br>
	<a href="walls">home</a>
	<a href="profiles">profile</a>
	<a href="friends">conneXions</a>
	<a href="jobs">jobs</a>
	<a href="notifications">notifications</a>
	<a href="messages">messages</a>
	<a href="groups">groups</a>

	<form action="search" method="post">
		<input size="5" type="text" name="searchString" /><input
			type="submit" name="action" value="search">
	</form>
	<h2>status feed</h2>
	<c:forEach var="wall" items="${wall}">
		<h4>
			<c:out value="${wall.friend.firstName}" />
			<c:out value="${wall.friend.lastName}" />
			<c:out value="${wall.friend.position}" />
			<c:out value="${wall.friend.institution}" />
		</h4>
		<c:out value="${wall.status}" />
		<c:forEach var="comments" items="${wall.commentList}">
			<h5>
			<c:out value="${comments.friend.firstName}" />
			<c:out value="${comments.friend.lastName}" />
			<c:out value="${comments.friend.position}" />
			<c:out value="${comments.friend.institution}" />
			</h5>
			<c:out value="${comments.created}" />
			<c:out value="${comments.comment}" />
		</c:forEach>
	</c:forEach>


	<form action="users" method="post">
		<input type="submit" name="action" value="logout" />
	</form>
</body>
</html>
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
	<a href="home.jsp">home</a>
	<a href="profiles">profile</a>
	<a href="notifications/index.jsp">notifications</a>
	<a href="friends">conneXions</a>
	<a href="messages/index.jsp">messages</a>
	<a href="groups/index.jsp">groups</a>
	<a href="jobs/index.jsp">jobs</a>
	
	
	<form action="search" method="post">
		<input size="5" type="text" name="searchString" /><input
			type="submit" name="action" value="search">
	</form>

	<form action="users" method="post">
		<input type="submit" name="action" value="logout" />
	</form>
</body>
</html>
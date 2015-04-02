<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  NEED JAVASCRIPT VALIDATION ON PASSWORD MATCHES -->
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Register</title>
</head>
<body>
	<h1>Register</h1>
	<form action="users" method="post">
		email <input type="text" name="username" /><br>
		password <input type="text" name="password" /><br>
		verify password <input type="text" name="passwordMatch" /><br>
		<input type="submit" name="action" value="register"/>
	</form>
	<p><a href="login.jsp">login</a></p>
	<p><a href="forgotpassword.jsp">forgot password</a></p>
</body>
</html>
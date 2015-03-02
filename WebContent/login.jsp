<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="users" method="post" >
		username: <input type="text" name="username" /><br>
		password: <input type="text" name="password" /> 
		<input type="submit" name="action" value="login"/>
	</form>
	<p><a href="register.jsp">register</a></p>
	<p><a href="forgotpassword.jsp">forgot password</a></p>
</body>
</html>
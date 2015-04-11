<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/foundation.css" />
<script src="js/vendor/modernizr.js"></script>
<title>conneXions - Sign in</title>
</head>
<body>
	<div class="large-9 large-centered columns">
		<div style="margin-top: 100px;">
			<div class="row">
				<div class="large-4 large-centered columns">
					<div class="row">
						<div class="large-12 columns">
							<img src="img/logo_text.svg" class="logo-small">
						</div>
						

					</div>
					<form action="users" method="post">
						<div class="row">
							<div class="large-12 columns">
								<input type="text" name="username" placeholder="Username" />
							</div>
						</div>
						<div class="row">
							<div class="large-12 columns">
								<input type="text" name="password" placeholder="Password" />
							</div>
						</div>
						<div class="row">
							<div class="large-12 large-centered columns">
								<input type="submit" class="button expand" name="action"
									value="Sign in" />
							</div>
						</div>
					</form>
					<div class="row">
						<div class="large-5 columns">
							<a href="register.jsp">Register</a>
						</div>
						<div class="large-7 columns text-right">
							<a href="forgotpassword.jsp">Forgot password?</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
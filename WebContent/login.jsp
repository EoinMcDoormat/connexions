<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/foundation.css" />
<script src="js/vendor/modernizr.js"></script>
<title>conneXions - login</title>
</head>
<body>
<div class="large-9 large-centered columns">
  <div style="margin-top:100px;">
  <div class="row">
  <div class="large-6 columns">
  <h1>Welcome to conne<div class="logo"></div>ions</h1>
  </div>
  <div class="large-3 columns">
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
          <input type="submit" class="button expand" name="action" value="login"/>
        </div>
      </div>
    </form>
  </div>
</div>
</div>
</div>

	<p>
		<a href="register.jsp">register</a>
	</p>
	<p>
		<a href="forgotpassword.jsp">forgot password</a>
	</p>
</body>
</html>
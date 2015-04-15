<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>conneXions | Home</title>
<link rel="stylesheet" href="css/foundation.css" />
<script src="js/vendor/modernizr.js"></script>
<link rel="stylesheet" href="foundation-icons/foundation-icons.css" />
</head>
<body>
	<div class="icon-bar eight-up">
		<a class="item" href="walls"> <i class="fi-home"></i><label
			id='homeLabel'>Home</label>
		</a> <a class="item" href="profiles"> <i class="fi-torso-business"></i><label
			id='profileLabel'>Profile</label>
		</a> <a class="item" href="notifications"> <i class="fi-flag"></i><label
			id='notificationsLabel'>Notifications</label>
		</a> <a class="item" href="friends"> <img src="img/logo_icon.svg"><label
			id='connexionsLabel'>conneXions</label>
		</a> <a class="item" href="jobs"> <i class="fi-shopping-bag"></i><label
			id='jobsLabel'>Jobs</label>
		</a> <a class="item" href="groups"> <i class="fi-torsos-all"></i><label
			id='groupsLabel'>Groups</label>
		</a> <a class="item" href="messages"> <i class="fi-mail"></i><label
			id='inboxLabel'>Messages</label>
		</a><a class="item" href="users"> <i class="fi-power"></i><label
			id='logoutLabel'>Sign out</label>
		</a>
	</div>
	<div class="row">
		<div class="large-12 columns">
			<div class="large-8 columns">
			<c:forEach var="notification" items="${notifications}">
<c:out value="${notification.id}" />
<c:out value="${notification.notificationType}" />
<c:out value="${notification.link}" />
<c:out value="${notification.read}" />
</c:forEach>

							</div>
		</div>
	</div>
	<footer class="footer">
		<div class="row full-width">
			<div class="large-4 columns">
				<img src="img/logo_text.svg" class="logo-small">
			</div>
			<div class="large-8 columns">
				<ul class="inline-list left">
					<li><a href="walls">Home</a></li>
					<li><a href="profiles">Profile</a></li>
					<li><a href="notifications">Notifications</a></li>
					<li><a href="friends">conneXions</a></li>
					<li><a href="jobs">Jobs</a></li>
					<li><a href="groups">Groups</a></li>
					<li><a href="messages">Messages</a></li>
				</ul>
			</div>
		</div>
	</footer>
	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation.min.js"></script>
	<script>
		$(document).foundation();
	</script>
</body>
</html>
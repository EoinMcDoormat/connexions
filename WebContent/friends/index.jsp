<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>conneXions | conneXions</title>
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
			</br>
				<h1>
					<c:out value="${currentSessionUser.firstName}" />
					<c:out value="${currentSessionUser.lastName}" />
					's ConneXions:
				</h1>
			</div>
			<div class="large-4 columns">
				<div class="blue">
					<div class="row collapse">
						<div class="large-10 columns">
							<input type="text" placeholder="Search jobs, connexions..." />
						</div>
						<div class="large-2 end columns">
							<span class="postfix"><i class="fi-magnifying-glass"></i></span>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<div class="row">
			<div class="large-12 columns">
				<c:forEach var="friends" items="${friends}">
					
					<div class="large-6 small-6 columns">
						<fieldset><legend><a href="profiles/views/<c:out value="${friends.id}" />">
									<c:out value="${friends.firstName}" />
									<c:out value="${friends.lastName}" /></a></legend>
							<div class="large-4 columns">
								<a href="profiles/views/<c:out value="${friends.id}" />"><img class="photo-connexions"
									src="img/profiles/<c:out value="${friends.id}" />.jpg" /></a>
							</div>

							<div class="large-8 columns">
								<h5><strong> <c:out
												value="${friends.position}" /></strong> <i>in</i>
									 <c:out value="${friends.institution.institution}" />
								</h5>
							</div>
						</fieldset>
					</div>
					
				</c:forEach>
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
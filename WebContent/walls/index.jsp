<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Foundation | Welcome</title>
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
		</a><a class="item" href="logout"> <i class="fi-power"></i><label
			id='logoutLabel'>Sign out</label>
		</a>
	</div>

	<div class="row">
		<div class="large-12 columns">
			<div class="large-8 columns">
				<div class="panel">
					<form action="walls" method="post">
						<textarea name="status" rows="2"
							placeholder="Post a status message..."></textarea>
						<button type="submit" class="radius button tiny right">Post</button>
					</form>
				</div>
				<c:forEach var="wall" items="${wall}">
					<div class="panel">
						<div class="row">
							<div class="large-3 columns">
								<img src="http://placehold.it/100x100" />
							</div>
							<div class="large-9 columns">

								<h5>
									<c:out value="${wall.friend.firstName}" />
									<c:out value="${wall.friend.lastName}" />
								</h5>
								<p>
									<c:out value="${wall.created}" />
									<c:out value="${wall.status}" />
								</p>
							</div>
						</div>
						<c:forEach var="comments" items="${wall.commentList}">
							<div class="row">
								<div class="large-9 columns right comment">
									<div class="large-3 columns">
										<img src="http://placehold.it/75x75" />
									</div>
									<div class="large-9 columns">
										<h4>
											<small><c:out value="${comments.friend.firstName}" />
												<c:out value="${comments.friend.lastName}" /> <c:out
													value="${comments.created}" /></small>
										</h4>
										<h5>
											<small><c:out value="${comments.comment}" /></small>
										</h5>
									</div>
								</div>
							</div>
						</c:forEach>
											<div class="row">
											<div class="large-9 columns">
										<form action="walls" method="post">
						<textarea name="comment" rows="1"
							placeholder="Write a comment"></textarea>
						<button type="submit" class="radius button tiny right">Comment</button>
					</form>
					</div>
					</div>
					</div>

				</c:forEach>
			</div>
			<div class="large-4 columns">
				<div class="panel">
					<div class="row collapse">
						<div class="large-10 columns">
							<input type="text" placeholder="Search jobs, connexions..." />
						</div>
						<div class="large-2 end columns">
							<span class="postfix"><i class="fi-magnifying-glass"></i></span>
						</div>
					</div>
				</div>
				<div class="panel">
					<h5>Latest Jobs</h5>
				</div>
				<div class="panel">
					<h5>My Groups</h5>
				</div>
			</div>

		</div>

	</div>

	<footer class="footer">
		<div class="row full-width">
			<div class="large-4 columns">
				<img src="img/logo_text.svg" class="logo-small">
			</div>
			<div class="large-8 columns">
				<ul class="inline-list right">
					<li><a href="#">Home</a></li>
					<li><a href="#">Profile</a></li>
					<li><a href="#">Notifications</a></li>
					<li><a href="#">conneXions</a></li>
					<li><a href="#">Jobs</a></li>
					<li><a href="#">Groups</a></li>
					<li><a href="#">Messages</a></li>
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
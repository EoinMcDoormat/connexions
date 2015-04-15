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
				<h2>
					Welcome,
					<c:out value="${currentSessionUser.firstName}" />
					<c:out value="${currentSessionUser.lastName}" />!
				</h2>
				<div class="radius panel">
					<div class="row">
						<form action="walls" method="post">
							<textarea name="status" rows="2"
								placeholder="Post a status message..."></textarea>
							<input type="submit" value="Post status"
								class="radius button right">
						</form>
					</div>
				</div>
				<c:forEach var="wall" items="${wall}">
					<div class="row">
<div class="large-12 columns">
								<div class="row collapse">
									<div class="small-3 medium-2 columns">
								<img class="photo-status"
									src="img/profiles/<c:out value="${wall.friend.id}" />.jpg" />
							</div>
									<div class="small-9 medium-10 columns">
										<div class="panel status">
											<h4>
									<a href="profiles/view/<c:out value="${wall.friend.id}"/>">
										<c:out value="${wall.friend.firstName}" /> <c:out
											value="${wall.friend.lastName}" />
									</a> <small> <c:out value="${wall.created}" />
									</small>
								</h4>
								<h5>
									<c:out value="${wall.status}" />
								</h5>
							</div>
							</div>
						</div>
						</div>
						<c:forEach var="comments" items="${wall.commentList}">
							<div class="large-10 columns right">
								<div class="row collapse">
									<div class="small-3 medium-2 columns">
										<img class="photo-comment"
											src="img/profiles/<c:out value="${comments.friend.id}" />.jpg" />
									</div>
									<div class="small-9 medium-10 columns">
										<div class="panel comment-small">
											<h6>
												<a
													href="profiles/view/<c:out value="${comments.friend.id}"/>">
													<c:out value="${comments.friend.firstName}" /> <c:out
														value="${comments.friend.lastName}" />
												</a><small> <c:out value="${comments.created}" /></small>
											</h6>
											<h6 class="h7">
												<c:out value="${comments.comment}" />
											</h6>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
						<div class="large-10 columns right">
							<form action="walls" method="post" autocomplete='off'>
								<input type="hidden" name="status_id" value="${wall.id}">
								<div class="row collapse">
									<div class="small-9 medium-10 columns">
										<input name="comment" type="text"
											placeholder="Write a comment">
									</div>
									<div class="small-3 medium-2 columns">
										<input type="submit" value="Comment"
											class="radius button postfix">
											
									</div>
								</div>
							</form>
						</div>
					
					</div>
					<hr>
				</c:forEach>
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
				<div class="radius panel">
					<h5>Notifications</h5>
				</div>
				<div class="radius panel">
					<h5>Latest Jobs</h5>
				</div>
				<div class="radius panel">
					<h5>My Groups</h5>
				</div>
				<div class="radius panel">
					<h5>My conneXions</h5>
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
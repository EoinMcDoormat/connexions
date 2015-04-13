<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>conneXions | Jobs</title>
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
			<div class="row">
				<div class="large-8 columns">
					<br>
					<h1>Jobs</h1>
				</div>

				<div class="large-4 columns">
					<div class="radius blue">
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
			<div class="row">
				<div class="large-12 columns">
					<ul class="radius tabs" data-tab role="tablist">
						<li class="tab-title active" role="presentational"><a
							href="#panel2-1" role="tab" tabindex="0" aria-selected="false"
							controls="panel2-1"><strong>Latest Jobs</strong></a></li>
						<li class="tab-title" role="presentational"><a
							href="#panel2-2" role="tab" tabindex="0" aria-selected="false"
							controls="panel2-2"><strong>My Jobs</strong></a></li>
						<li class="tab-title" role="presentational"><a
							href="#panel2-3" role="tab" tabindex="0" aria-selected="false"
							controls="panel2-3"><strong>Post a job</strong></a></li>
					</ul>
					<div class="tabs-content">
						<section role="tabpanel" aria-hidden="false"
							class="content active" id="panel2-1">
							<table>
								<tbody>

									<c:forEach var="jobs" items="${jobs}">
										<tr>
											<td><h5>
													<a href="jobs/view/<c:out value="${jobs.id}" />"><c:out
															value="${jobs.positions}" /></a>
												</h5></td>
													<td><c:out value="${jobs.poster.institution.institution}" /></td>
													<td><c:out value="${jobs.poster.institution.location.location}" /></td>
													<td>
													<c:out value="${jobs.poster.firstName}" />
													<c:out value="${jobs.poster.lastName}" />
													</td>
													<td>
													<fmt:parseDate value="${jobs.created}" var="parsedDate" pattern="yyyy-MM-dd" />
													<fmt:formatDate type="date" value="${parsedDate}" />
													</td>
											<td><a href="jobs/view/<c:out value="${jobs.id}" />"
												class="radius button small">Read more</a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>

						</section>
						<section role="tabpanel" aria-hidden="true" class="content"
							id="panel2-2">
							<table>
								<tbody>
									<c:forEach var="myjob" items="${jobs}">
										<c:choose>
											<c:when test="${currentSessionUser.id == myjob.poster.id}">
												<tr>
													<td><h5>
															<a href="jobs/view/<c:out value="${myjob.id}" />"><c:out
																	value="${myjob.positions}" /></a>
														</h5></td>
													<td><c:out value="${myjob.poster.institution.institution}" /></td>
													<td><c:out value="${myjob.poster.institution.location.location}" /></td>
													<td>
													<c:out value="${myjob.poster.firstName}" />
													<c:out value="${myjob.poster.lastName}" />
													</td>
													<td>
													<fmt:parseDate value="${myjob.created}" var="parsedDate" pattern="yyyy-MM-dd" />
													<fmt:formatDate type="date" value="${parsedDate}" />													
													</td>
													<td><a href="jobs/edit/<c:out value="${myjob.id}" />"
														class="radius button small">Edit Job</a></td>
												</tr>
											</c:when>
										</c:choose>
									</c:forEach>
								</tbody>
							</table>
						</section>
						<section role="tabpanel" aria-hidden="true" class="content"
							id="panel2-3"></section>
					</div>
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
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="year" value="${now}" pattern="yyyy" />
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>conneXions | Profile</title>
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
					<h1>
						<c:out value="${currentSessionUser.firstName}" />
						<c:out value="${currentSessionUser.lastName}" />
						's Profile
					</h1>
					<div class="radius panel">

						<form action="profiles" method="post">
							<div class="row">
								<div class="large-4 columns">
									<div class="panel text-center">
										<img class="photo-profile"
											src="img/profiles/<c:out value="${currentSessionUser.id}" />.jpg" />
									</div>
								</div>
								<div class="large-8 columns">
									<label>First name <input type="text" name="firstName"
										placeholder="First name" value="${profile.first_name}" />
									</label> <label>Last name <input type="text" name="lastName"
										placeholder="Last name" value="${profile.last_name}" />
									</label>
								</div>
							</div>
							<div class="row">
								<div class="large-12 columns">
									<label>Summary <textarea name="summary"
											placeholder="Write a short description or a personal profile statement...">${profile.summary}</textarea>
									</label>
								</div>
							</div>
							<div class="row">
								<div class="large-6 columns">
									<label>Position <select name="position">
											<c:forEach var="position" items="${positions}">
												<c:choose>
													<c:when test="${profile.position==position.position}">
														<option value="<c:out value="${position.id}" />" selected>
															<c:out value="${position.position}" />
													</c:when>
													<c:otherwise>
														<option value="<c:out value="${position.id}" />">
															<c:out value="${position.position}" />
													</c:otherwise>
												</c:choose>
											</c:forEach>
									</select>
									</label>
								</div>
								<div class="large-6 columns">
									<label>Institution <select name="institution">
											<c:forEach var="institution" items="${institutions}">
												<c:choose>
													<c:when
														test="${profile.institution==institution.institution}">
														<option value="<c:out value="${institution.id}" />"
															selected>
															<c:out value="${institution.institution}" />
													</c:when>
													<c:otherwise>
														<option value="<c:out value="${institution.id}" />">
															<c:out value="${institution.institution}" />
													</c:otherwise>
												</c:choose>
											</c:forEach>
									</select>
									</label>
								</div>
							</div>
							<div class="row">
								<input type="submit" name="personalProfile"
									value="Save personal profile" class="radius button right">
							</div>
						</form>
					</div>
					<ul class="radius tabs" data-tab role="tablist">
						<li class="tab-title active" role="presentational"><a
							href="#panel2-1" role="tab" tabindex="0" aria-selected="false"
							controls="panel2-1">Education</a></li>
						<li class="tab-title" role="presentational"><a
							href="#panel2-2" role="tab" tabindex="0" aria-selected="false"
							controls="panel2-2">Clubs and Socs</a></li>
						<li class="tab-title" role="presentational"><a
							href="#panel2-3" role="tab" tabindex="0" aria-selected="false"
							controls="panel2-3">Experience</a></li>
						<li class="tab-title" role="presentational"><a
							href="#panel2-4" role="tab" tabindex="0" aria-selected="false"
							controls="panel2-4">Skills</a></li>
					</ul>
					<div class="tabs-content">
						<section role="tabpanel" aria-hidden="false"
							class="content active" id="panel2-1">
							<fieldset>
								<c:forEach var="education" items="${profile.educationList}">
									<h3>
										<c:out value="${education.institution}" />
									</h3>
									<c:out value="${education.id}" />
									<c:out value="${education.level}" />
									<c:out value="${education.qualification}" />
									<c:out value="${education.fieldOfStudy}" />
									<c:out value="${education.start}" />
									<c:out value="${education.end}" />
									<c:out value="${education.grade}" />
									<c:out value="${education.description}" />

									<c:forEach var="results" items="${education.resultList}">
										<c:out value="${results.year}" />
										<c:out value="${results.subject}" />
										<c:out value="${results.result}" />
										<br />
									</c:forEach>
								</c:forEach>
							</fieldset>
						</section>
						<section role="tabpanel" aria-hidden="true" class="content"
							id="panel2-2">
							<c:forEach var="clubsandsocs" items="${profile.clubsAndSocsList}">
								<form action="profiles" name="clubSoc" method="post">
									<input type="hidden" name="profileClubSocId"
										value="<c:out value="${clubsandsocs.id}" />">
									<fieldset>    <legend>Edit Records</legend>
										<div class="row">
											<div class="large-6 columns">
												<label>Position <select name="clubSocPosition">
														<c:forEach var="position" items="${clubPositions}">
															<c:choose>
																<c:when test="${clubsandsocs.position.id==position.id}">
																	<option value="<c:out value="${position.id}" />"
																		selected>
																		<c:out value="${position.position}" />
																</c:when>
																<c:otherwise>
																	<option value="<c:out value="${position.id}" />">
																		<c:out value="${position.position}" />
																</c:otherwise>
															</c:choose>
														</c:forEach>
												</select>
												</label>
											</div>
											<div class="large-6 columns">
												<label>Club/Society <select name="clubSoc">
														<c:forEach var="clubsoc" items="${clubsocs}">
															<c:choose>
																<c:when test="${clubsandsocs.clubsoc.id==clubsoc.id}">
																	<option value="<c:out value="${clubsoc.id}" />"
																		selected>
																		<c:out value="${clubsoc.name}" />
																</c:when>
																<c:otherwise>
																	<option value="<c:out value="${clubsoc.id}" />">
																		<c:out value="${clubsoc.name}" />
																</c:otherwise>
															</c:choose>
														</c:forEach>
												</select>
												</label>
											</div>
										</div>
										<div class="row">
											<div class="large-3 columns">
												<fmt:formatDate var="csStart" value="${clubsandsocs.start}"
													pattern="yyyy" />
												<label>Start <select name="clubSocStart">
														<c:forEach begin="1990" end="${year}" var="i">
															<c:choose>
																<c:when test="${csStart==i}">
																	<option value="${i}" selected>${i}</option>
																</c:when>
																<c:otherwise>
																	<option value="${i}">${i}</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
												</select>
												</label>
											</div>
											<div class="large-3 columns">
												<fmt:formatDate var="csEnd" value="${clubsandsocs.end}"
													pattern="yyyy" />
												<label>End <select name="clubSocEnd">
														<c:set var="csSelected" value="false" />
														<c:forEach begin="1990" end="${year}" var="i">
															<c:choose>
																<c:when test="${csEnd==i}">
																	<option value="${i}" selected>${i}</option>
																	<c:set var="csSelected" value="true" />
																</c:when>
																<c:otherwise>
																	<option value="${i}">${i}</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
														<c:if test="${csSelected eq 'false'}">
															<option value="0" selected>-</option>
														</c:if>
														<c:if test="${csSelected eq 'true'}">
															<option value="0">-</option>
														</c:if>
												</select>
												</label>
											</div>
											<div class="large-6 columns"></div>
										</div>

										<div class="row">
											<div class="large-12 columns">
												<label>Summary <textarea name="clubSocDesc"
														placeholder="Brief description of activities in club/soc"><c:out
															value="${clubsandsocs.description}" /></textarea>
												</label>
											</div>
										</div>
										<div class="row">
											<input type="submit" value="Save changes" name="clubsAndSocs"
												class="radius button right">
										</div>
									</fieldset>
								</form>
							</c:forEach>
								<form action="profiles" name="clubSocNew" method="post">
									<fieldset class="new">
										<div class="row">
											<div class="large-6 columns">
												<label>Position <select name="clubSocPosition">
														<c:forEach var="position" items="${clubPositions}">
																<option value="<c:out value="${position.id}" />">
																		<c:out value="${position.position}" />
														</c:forEach>
												</select>
												</label>
											</div>
											<div class="large-6 columns">
												<label>Club/Society <select name="clubSoc">
														<c:forEach var="clubsoc" items="${clubsocs}">
																	<option value="<c:out value="${clubsoc.id}" />">
																		<c:out value="${clubsoc.name}" />																
														</c:forEach>
												</select>
												</label>
											</div>
										</div>
										<div class="row">
											<div class="large-3 columns">
												<label>Start <select name="clubSocStart">
														<c:forEach begin="1990" end="${year}" var="i">
																	<option value="${i}">${i}</option>
														</c:forEach>
												</select>
												</label>
											</div>
											<div class="large-3 columns">
												<label>End <select name="clubSocEnd">
														<c:set var="csSelected" value="false" />
														<c:forEach begin="1990" end="${year}" var="i">
																	<option value="${i}">${i}</option>															
														</c:forEach>
															<option value="0" selected>-</option>														
												</select>
												</label>
											</div>
											<div class="large-6 columns"></div>
										</div>

										<div class="row">
											<div class="large-12 columns">
												<label>Summary <textarea name="clubSocDesc"
														placeholder="Brief description of activities in club/soc"><c:out
															value="${clubsandsocs.description}" /></textarea>
												</label>
											</div>
										</div>
										<div class="row">
											<input type="submit" value="Add new" name="clubsAndSocs"
												class="radius button success right">
										</div>
									</fieldset>
								</form>
						</section>
						<section role="tabpanel" aria-hidden="true" class="content"
							id="panel2-3">
							<h2>experience</h2>
							<c:forEach var="experience" items="${profile.experienceList}">
								<h3>
									<c:out value="${experience.company}" />
								</h3>
								<c:out value="${experience.location}" />
								<c:out value="${experience.position}" />
								<c:out value="${experience.description}" />
								<c:out value="${experience.start}" />
								<c:out value="${experience.end}" />
							</c:forEach>
						</section>
						<section role="tabpanel" aria-hidden="true" class="content"
							id="panel2-4">
							<h2>skills</h2>
							<c:forEach var="skill" items="${profile.skillList}">
								<c:out value="${skill.skill}" />
							</c:forEach>
						</section>
					</div>
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
					<div class="radius panel">
						<h5>Privacy</h5>
						<div class="row">
							<div class="small-4 medium-4 large-4 columns">
								<i class="fi-lock right"></i>
							</div>
							<div class="small-4 medium-4 large-4 columns">
								<div class="switch radius">
									<input id="exampleCheckboxSwitch" type="checkbox"> <label
										for="exampleCheckboxSwitch"></label>
								</div>
							</div>
							<div class="small-4 medium-4 large-4 columns">
								<i class="fi-unlock left"></i>
							</div>
						</div>
					</div>
					<div class="small-12 small-centered text-center">
						<button href="#" data-dropdown="drop1" aria-controls="drop1"
							aria-expanded="false" class="radius button dropdown">View
							my profile as</button>
						<br>
						<ul id="drop1" data-dropdown-content class="f-dropdown"
							aria-hidden="true">
							<li><a href="#">a conneXion</a></li>
							<li><a href="#">someone outside my network</a></li>
						</ul>
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
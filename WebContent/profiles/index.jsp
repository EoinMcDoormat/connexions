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
<link rel="stylesheet" type="text/css"
	href="datetimepicker/jquery.datetimepicker.css"/ >
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
					<h2>
						<c:out value="${currentSessionUser.firstName}" />
						<c:out value="${currentSessionUser.lastName}" />
						's Profile
					</h2>
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
							<c:forEach var="education" items="${profile.educationList}">
								<form action="profiles" name="education" method="post">
									<input type="hidden" name="profileEducationId"
										value="<c:out value="${education.id}" />">
									<fieldset>
										<legend>
											<c:out value="${education.qualification.qualification}" />
											in
											<c:out value="${education.institution.institution}" />
										</legend>
										<div class="row">
											<div class="large-6 columns">
												<label>Qualification <select
													name="educationQualification">
														<c:forEach var="qualification" items="${qualifications}">
															<c:choose>
																<c:when
																	test="${education.qualification.id==qualification.id}">
																	<option value="<c:out value="${qualification.id}" />"
																		selected>
																		<c:out value="${qualification.qualification}" />
																</c:when>
																<c:otherwise>
																	<option value="<c:out value="${qualification.id}" />">
																		<c:out value="${qualification.qualification}" />
																</c:otherwise>
															</c:choose>
														</c:forEach>
												</select>
												</label>
											</div>
											<div class="large-6 columns">
												<label>Institution <select
													name="educationInstitution">
														<c:forEach var="institution" items="${institutions}">
															<c:choose>
																<c:when
																	test="${education.institution.id==institution.id}">
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
											<div class="large-6 columns">
												<label>Field of Study <select
													name="educationFieldOfStudy">
														<c:forEach var="field" items="${fields}">
															<c:choose>
																<c:when test="${education.fieldOfStudy.id==field.id}">
																	<option value="<c:out value="${field.id}" />" selected>
																		<c:out value="${field.fieldOfStudy}" />
																</c:when>
																<c:otherwise>
																	<option value="<c:out value="${field.id}" />">
																		<c:out value="${field.fieldOfStudy}" />
																</c:otherwise>
															</c:choose>
														</c:forEach>
												</select>
												</label>
											</div>
											<div class="large-3 columns">
												<label>Start <select name="educationStart">
														<c:forEach begin="1990" end="${year}" var="i">
															<c:choose>
																<c:when test="${education.start==i}">
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
												<label>End <select name="educationEnd">
														<c:set var="edSelected" value="false" />
														<c:forEach begin="1990" end="${year}" var="i">
															<c:choose>
																<c:when test="${education.end==i}">
																	<option value="${i}" selected>${i}</option>
																	<c:set var="edSelected" value="true" />
																</c:when>
																<c:otherwise>
																	<option value="${i}">${i}</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
														<c:if test="${edSelected eq 'false'}">
															<option value="0" selected>-</option>
														</c:if>
														<c:if test="${edSelected eq 'true'}">
															<option value="0">-</option>
														</c:if>
												</select>
												</label>
											</div>
										</div>
										<div class="row">
											<div class="large-4 columns">
												<label>Grade <input type="text"
													name="educationGrade" placeholder="Grade"
													value="${education.grade}" />
												</label>
											</div>
										</div>
										<div class="row">
											<div class="large-12 columns">
												<label>Summary <textarea name="educationDescription"
														placeholder="Brief description of course topics, moducles covered, etc."><c:out
															value="${education.description}" /></textarea>
												</label>
											</div>
										</div>
										<div class="row">
											<div class="large-12 columns">
												<h4 class="subheader">Results</h4>
												<table>
													<tbody>
														<th width="15%">Year</th>
														<th width="40%">Subject</th>
														<th width="15%">Result</th>
														<th width="30%"></th>
														<c:forEach var="result" items="${education.resultList}">
															<form action="profiles" name="resultsChange"
																method="post">
																<tr>
																	<input type="hidden" name="resultId"
																		value="<c:out value="${result.id}" />">
																	<input type="hidden" name="educationId"
																		value="<c:out value="${education.id}" />">
																	<td><select name="resultYear">
																			<c:forEach begin="${education.start}"
																				end="${education.end==0 ? now : education.end}"
																				var="i">
																				<c:choose>
																					<c:when test="${result.year==i}">
																						<option value="${i}" selected>${i}</option>
																					</c:when>
																					<c:otherwise>
																						<option value="${i}">${i}</option>
																					</c:otherwise>
																				</c:choose>
																			</c:forEach>
																	</select></td>
																	<td><input type="text" name="resultSubject"
																		placeholder="Subject" value="${result.subject}" /></td>
																	<td><input type="text" name="resultResult"
																		placeholder="Result" value="${result.result}" /></td>
																	<td class="results-input"><input type="submit"
																		value="Delete" name="resultDelete"
																		class="radius button tiny left"><input
																		type="submit" value="Save" name="resultChange"
																		class="radius button tiny right"></td>
																</tr>
															</form>
														</c:forEach>
														<form action="profiles" name="resultsAdd" method="post">
															<tr class="new">
																<input type="hidden" name="educationId"
																	value="<c:out value="${education.id}" />">
																<td><select name="resultYear">
																		<c:forEach begin="${education.start}"
																			end="${education.end==0 ? now : education.end}"
																			var="i">
																			<option value="${i}">${i}</option>
																		</c:forEach>
																</select></td>
																<td><input type="text" name="resultSubject"
																	placeholder="Subject" /></td>
																<td><input type="text" name="resultResult"
																	placeholder="Result" /></td>
																<td class="results-input"><input type="submit"
																	value="Add new" name="resultAdd"
																	class="radius button tiny right success"></td>

															</tr>
														</form>

													</tbody>
												</table>
											</div>
										</div>
										<div class="row">
											<div class="large-12 columns text-right">
												<input type="submit" value="Delete" name="educationDelete"
													class="radius button"> <input type="submit"
													value="Save changes" name="educationChange"
													class="radius button">
											</div>
										</div>
									</fieldset>
								</form>
							</c:forEach>
							<form action="profiles" name="education" method="post">
								<input type="hidden" name="profileEducationId"
									value="<c:out value="${education.id}" />">
								<fieldset class="new">
									<legend> Add New </legend>
									<div class="row">
										<div class="large-6 columns">
											<label>Qualification <select
												name="educationQualification">
													<c:forEach var="qualification" items="${qualifications}">
														<option value="<c:out value="${qualification.id}" />">
															<c:out value="${qualification.qualification}" />
													</c:forEach>
											</select>
											</label>
										</div>
										<div class="large-6 columns">
											<label>Institution <select
												name="educationInstitution">
													<c:forEach var="institution" items="${institutions}">
														<option value="<c:out value="${institution.id}" />">
															<c:out value="${institution.institution}" />
													</c:forEach>
											</select>
											</label>
										</div>
									</div>
									<div class="row">
										<div class="large-6 columns">
											<label>Field of Study <select
												name="educationFieldOfStudy">
													<c:forEach var="field" items="${fields}">
														<option value="<c:out value="${field.id}" />">
															<c:out value="${field.fieldOfStudy}" />
													</c:forEach>
											</select>
											</label>
										</div>
										<div class="large-3 columns">
											<label>Start <select name="educationStart">
													<c:forEach begin="1990" end="${year}" var="i">
														<option value="${i}">${i}</option>
													</c:forEach>
											</select>
											</label>
										</div>
										<div class="large-3 columns">
											<label>End <select name="educationEnd">
													<c:set var="edSelected" value="false" />
													<c:forEach begin="1990" end="${year}" var="i">
														<option value="${i}">${i}</option>
													</c:forEach>
													<option value="0" selected>-</option>
											</select>
											</label>
										</div>
									</div>
									<div class="row">
										<div class="large-4 columns">
											<label>Grade <input type="text" name="educationGrade"
												placeholder="Grade" />
											</label>
										</div>
									</div>
									<div class="row">
										<div class="large-12 columns">
											<label>Summary <textarea name="educationDescription"
													placeholder="Brief description of course topics, moducles covered, etc."></textarea>
											</label>
										</div>
									</div>
									<div class="row">
										<div class="large-12 columns text-right">
											<input type="submit" value="Add New" name="educationAdd"
												class="radius button success">
										</div>
									</div>
								</fieldset>
							</form>
						</section>

						<section role="tabpanel" aria-hidden="true" class="content"
							id="panel2-2">
							<c:forEach var="clubsandsocs" items="${profile.clubsAndSocsList}">
								<form action="profiles" name="clubSoc" method="post">
									<input type="hidden" name="profileClubSocId"
										value="<c:out value="${clubsandsocs.id}" />">
									<fieldset>
										<legend>
											<c:out value="${clubsandsocs.position.position}" />
											at
											<c:out value="${clubsandsocs.clubsoc.name}" />
										</legend>
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
											<div class="large-12 columns text-right">
												<input type="submit" value="Delete" name="clubsAndSocsDel"
													class="radius button"> <input type="submit"
													value="Save changes" name="clubsAndSocs"
													class="radius button">
											</div>
										</div>
									</fieldset>
								</form>
							</c:forEach>
							<form action="profiles" name="clubSocNew" method="post">
								<fieldset class="new">
									<legend>Add new</legend>
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
										<div class="large-12 columns text-right">

											<input type="submit" value="Add new" name="clubsAndSocsNew"
												class="radius button success">
										</div>
									</div>
								</fieldset>
							</form>
						</section>
						<section role="tabpanel" aria-hidden="true" class="content"
							id="panel2-3">
							<c:forEach var="experience" items="${profile.experienceList}">
								<form action="profiles" name="education" method="post">
									<input type="hidden" name="profileExperienceId"
										value="<c:out value="${experience.id}" />">
									<fieldset>
										<legend>
											<c:out value="${experience.position.position}" />
											at
											<c:out value="${experience.company.name}" />
										</legend>

										<div class="row">
											<div class="large-6 columns">
												<label>Position <select name="experiencePosition">
														<c:forEach var="position" items="${experiencePosition}">
															<c:choose>
																<c:when test="${experience.position.id==position.id}">
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
										</div>
										<div class="row">
											<div class="large-6 columns">
												<label>Company <select name="experienceCompany">
														<c:forEach var="company" items="${experienceCompanies}">
															<c:choose>
																<c:when test="${experience.company.id==company.id}">
																	<option value="<c:out value="${company.id}" />"
																		selected>
																		<c:out value="${company.name}" />
																</c:when>
																<c:otherwise>
																	<option value="<c:out value="${company.id}" />">
																		<c:out value="${company.name}" />
																</c:otherwise>
															</c:choose>
														</c:forEach>
												</select>
												</label>
											</div>
											<div class="large-6 columns">
												<label>Location <select name="experienceLocation">
														<c:forEach var="location" items="${locations}">
															<c:choose>
																<c:when test="${experience.location.id==location.id}">
																	<option value="<c:out value="${location.id}" />"
																		selected>
																		<c:out value="${location.location}" />
																</c:when>
																<c:otherwise>
																	<option value="<c:out value="${location.id}" />">
																		<c:out value="${location.location}" />
																</c:otherwise>
															</c:choose>
														</c:forEach>
												</select>
												</label>
											</div>
										</div>
										<div class="row">
											<div class="large-3 columns">
												<fmt:formatDate var="expStart" value="${experience.start}"
													pattern="MMM Y" />
												<label>Start <input name="expStartIn"
													id="datepickerStart" type="text" value="${expStart}">
												</label>
											</div>
											<div class="large-3 columns">
												<fmt:formatDate var="expEnd" value="${experience.end}"
													pattern="MMM Y" />
												<label>End <input name="expEndIn" id="datepickerEnd"
													type="text" value="${expEnd}">
												</label>
											</div>
											<div class="large-6 columns"></div>
										</div>

										<div class="row">
											<div class="large-12 columns">
												<label>Summary <textarea name="expDesc"
														placeholder="Brief description of responsibilities and skills..."><c:out
															value="${experience.description}" /></textarea>
												</label>
											</div>
										</div>
										<div class="row">
											<div class="large-12 columns text-right">
												<input type="submit" value="Delete" name="expDel"
													class="radius button"> <input type="submit"
													value="Save changes" name="experienceForm"
													class="radius button">
											</div>
										</div>
									</fieldset>
								</form>
							</c:forEach>

							<form action="profiles" name="education" method="post">

								<fieldset class="new">
									<legend> Add new </legend>

									<div class="row">
										<div class="large-6 columns">
											<label>Position <select name="experiencePosition">
													<c:forEach var="position" items="${experiencePosition}">

														<option value="<c:out value="${position.id}" />">
															<c:out value="${position.position}" />
													</c:forEach>
											</select>
											</label>
										</div>
									</div>
									<div class="row">
										<div class="large-6 columns">
											<label>Company <select name="experienceCompany">
													<c:forEach var="company" items="${experienceCompanies}">

														<option value="<c:out value="${company.id}" />">
															<c:out value="${company.name}" />
													</c:forEach>
											</select>
											</label>
										</div>
										<div class="large-6 columns">
											<label>Location <select name="experienceLocation">
													<c:forEach var="location" items="${locations}">
														<option value="<c:out value="${location.id}" />">
															<c:out value="${location.location}" />
													</c:forEach>
											</select>
											</label>
										</div>
									</div>
									<div class="row">
										<div class="large-3 columns">
											<fmt:formatDate var="nowFormat" value="${now}"
												pattern="MMM Y" />
											<label>Start <input name="expStartIn"
												id="datepickerStart" type="text" value="${nowFormat}">
											</label>
										</div>
										<div class="large-3 columns">
											<label>End <input name="expEndIn" id="datepickerEnd"
												type="text" value="${nowFormat}">
											</label>
										</div>
										<div class="large-6 columns"></div>
									</div>

									<div class="row">
										<div class="large-12 columns">
											<label>Summary <textarea name="expDesc"
													placeholder="Brief description of responsibilities and skills..."></textarea>
											</label>
										</div>
									</div>
									<div class="row">
										<div class="large-12 columns text-right">
											<input type="submit" value="Add new" name="experienceNew"
												class="radius button success">
										</div>
									</div>
								</fieldset>
							</form>
						</section>
						<section role="tabpanel" aria-hidden="true" class="content"
							id="panel2-4">
							<div class="row">
								<div class="large-12 columns">
									<table style="width: 60%;">
										<tbody>
											<c:forEach var="skill" items="${profile.skillList}">
												<form action="profiles" name="skillsChange" method="post">
													<tr>
														<input type="hidden" name="skillId"
															value="<c:out value="${skill.id}" />">
														<td><h6>
																<c:out value="${skill.skill}" />
															</h6></td>
														<td class="results-input"><input type="submit"
															value="Delete" name="skillDelete"
															class="radius button small right"></td>
													</tr>
												</form>
											</c:forEach>

											<form action="profiles" name="skillAdd" method="post">
												<tr class="new">
													<td><select name="profileSkill">
															<c:forEach var="skills" items="${skills}">
																<option value="<c:out value="${skills.id}" />">
																	<c:out value="${skills.skill}" />
															</c:forEach>
													</select></td>
													<td class="results-input"><input type="submit"
														value="Add new" name="skillAdd"
														class="radius button success small right"></td>

												</tr>
											</form>
										</tbody>
									</table>
								</div>
							</div>
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
								<i class="fi-unlock right"></i>
							</div>



							<div class="small-4 medium-4 large-4 columns">
								<div class="switch radius">
									<form name="privacyForm" action="profiles" method="post">
										<input type="hidden" name="privacyForm"
											value="<c:out value="${not profile.privacy}" />" /> <input
											name="privacyChkBx" id="exampleCheckboxSwitch"
											type="checkbox" onclick="document.privacyForm.submit();"
											<c:if test="${profile.privacy}">checked</c:if>> <label
											for="exampleCheckboxSwitch"></label>
									</form>
								</div>
							</div>
							<div class="small-4 medium-4 large-4 columns">
								<i class="fi-lock left"></i>
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
	<script src="datetimepicker/jquery.datetimepicker.js"></script>
	<script>
		$(document).foundation();
		$('#datepickerStart').datetimepicker({
			timepicker : false,
			format : 'M Y',
			formatDate : 'Y-d-m',
		});
		$('#datepickerEnd').datetimepicker({
			timepicker : false,
			format : 'M Y',
			formatDate : 'Y-d-m',
		});
	</script>
</body>
</html>
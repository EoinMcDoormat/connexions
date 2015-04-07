<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>profile</title>
</head>
<body>
	<h1>profile</h1>
	<h2>personal information</h2>
	${profile.first_name} ${profile.last_name} ${profile.summary}
	<h2>education</h2>
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
	<h2>clubs and socs</h2>
	<c:forEach var="clubsandsocs" items="${profile.clubsAndSocsList}">
		<h3>
			<c:out value="${clubsandsocs.clubsAndSocsName}" />
		</h3>
		<c:out value="${clubsandsocs.institution}" />
		<c:out value="${clubsandsocs.position}" />
		<c:out value="${clubsandsocs.description}" />
	</c:forEach>
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
		<h2>skills</h2>
			<c:forEach var="skill" items="${profile.skillList}">
		<c:out value="${skill.skill}" />		
	</c:forEach>
</body>
</html>

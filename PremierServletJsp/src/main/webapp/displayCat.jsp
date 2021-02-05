<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affichage des chats</title>
</head>
<body>
	<h1>Ça marche enfin! J'ai juste reclean calmement ;)</h1>
	<c:forEach var="cat" items="${cats}">
		<c:if test="${cat.race == 'Ragdoll' }">
			<ul>
				<li>${cat.name}</li>
				<li>${cat.race}</li>
			</ul>
		</c:if>
	</c:forEach>
</body>
</html>
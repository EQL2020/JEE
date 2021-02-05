<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affichage des chats</title>
</head>
<body>
<h1> Ça marche enfin! J'ai juste reclean calmement ;) </h1>
<ul>
	<c:forEach var="cat" items="${cats}">
		<li>${cat.name}</li>
	</c:forEach>
</ul>
</body>
</html>
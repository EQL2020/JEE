<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${prenom != null}">
		Bienvenue <c:out value="${prenom}"></c:out>
	</c:if>
	<c:if test="${prenom == null}" > 
		<form method="post" action="cookie.xyz">
			<label>Donne ton prénom pour obtenir un beau cookie</label>
			<input type="text" name="prenom"/>
			<input type="submit" value="Cookie !!!!"/>
		</form>
	</c:if>

</body>
</html>
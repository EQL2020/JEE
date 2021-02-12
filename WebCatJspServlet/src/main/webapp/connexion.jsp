<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	<h1>Connexion</h1>
	<form method="post" action="ConnexionServlet">
		Login: <input type="text" name="login"/><br/>
		Password: <input type="password" name="password"/><br/>
		<input type="submit" value="Connexion"/>
	</form>
	<c:if test="${message != null }">
		<label style="color:red">${message }</label>
	</c:if>
	<br/>
	User en session : ${user.name}
</body>
</html>
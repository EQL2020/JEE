<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vos chats</title>
</head>
<body style="background-color : lightblue">
	<div style="border: solid black 1px; background-color: teal">
		<span style="float: right; margin-right: 1vh; font-size: 3vh">
			Bonjour ${user.login} <a href="bye.jsp">Déconnexion</a>
		</span>
		<h1 style="text-align: center">Vos Chats</h1>
	</div>
	<c:forEach items="${cats}" var="cat">
		<fieldset style="float: left; height: 35vh; margin: 2vh; padding: 2vh; display:flex">
			<legend style="font-size: 3vh">${cat.name}</legend>	
			<img src="pics/${cat.photo}" style=" width: 30vh"/>
			<ul style="margin-top: 5vh">
				<li>Id: ${cat.id}</li>
				<li>Race: ${cat.race}</li>
				<li>Date de Naissance: ${cat.birth}</li>
			</ul>	
		</fieldset>
	</c:forEach>
</body>
</html>
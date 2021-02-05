<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Résultat V2</title>
</head>
<body>
	Vous avez choisi: <%=request.getAttribute("operation") %>
	<br/>
	Le résultat est: <%=request.getAttribute("resultat") %>
</body>
</html>
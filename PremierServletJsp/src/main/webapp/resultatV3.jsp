<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="resultat" class="fr.eql.ai108.modele.Resultat" scope="request"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Vous avez choisi: <jsp:getProperty property="operation" name="resultat"/>
	<br/>
	Le résultat est : <jsp:getProperty property="num" name="resultat"/>
</body>
</html>
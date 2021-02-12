<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<html:form action="/addUser.ai108">
		Nom: <html:text property="user.surname"/><br/>
		Prénom: <html:text property="user.name"/><br/>
		Login: <html:text property="user.login"/><br/>
		Password: <html:text property="user.password"/><br/>
		<html:submit value="Créer compte"/><br/>
		<span>${fbAddUser.message}</span>
	</html:form>
</body>
</html>
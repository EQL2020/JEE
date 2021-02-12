<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Premier Struts</title>
</head>
<body>
	<html:form action="/toto.ai108">
		Saisie: <html:text property="saisie"/>
		<html:submit value="Click !"/>
		${fbPremier.label}
	</html:form>

</body>
</html>
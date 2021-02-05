<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Résultat</title>
</head>
<body>
	<%
		//Récupération des params
		String op = request.getParameter("op");
		String nb1 = request.getParameter("n1");
		String nb2 = request.getParameter("n2");
		String operation = "";
		
		//Variables
		int num1 = 0; int num2 = 0; int num3 = 0;
		
		//Conversion
		num1 = Integer.parseInt(nb1);
		num2 = Integer.parseInt(nb2);
		
		//Calcul
		
		switch (op){
		
		case "add":
			num3 = num1 + num2;
			operation = "Addition";
			break;
		case "sub" :
			num3 = num1 - num2;
			operation = "Soustraction";
			break;
		case "div" :
			num3 = num1 / num2;
			operation = "Division";
			break;
		case "mul":
			num3 = num1 * num2;
			operation = "Multiplication";
			break;			
		}	
	%>
	Vous avez choisi: <%=operation %>
	<br/>
	Le résultat est <%=num3 %>
</body>
</html>
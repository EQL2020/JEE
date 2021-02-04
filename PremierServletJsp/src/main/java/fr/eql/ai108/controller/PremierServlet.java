package fr.eql.ai108.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Une servlet hérite de HttpServlet
public class PremierServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	//Un servlet doit avoir un constructeur vide explicite
	public PremierServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Ma première Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello AI108 !!!</h1>");
		out.println("<form method='POST' action='SecondServlet'>");
		out.println("Login: <input type='text' name='login'/><br/>");
		out.println("Password: <input type='password' name='password'/><br/> ");
		out.println("Sexe: <input type='radio' name='sexe' value='F'/> Femme");
		out.println("<input type='radio' name='sexe' value='H'/> Homme");
		out.println("<input type='radio' name='sexe' value='A'/> Autre <br/>");
		out.println("Pays: <select name='pays'>");
		out.println("<option value='--'> Choisir...</option>");
		out.println("<option value='France'>France</option>");
		out.println("<option value='Burkina Faso'>Burkina Faso</option>");
		out.println("<option value='Egypte'>Egypte</option>");
		out.println("</select><br/>");
		out.println("<input type='checkbox' name='optin'/>"
				+ " J'accepte les conditions d'utilisation <br/>");
		out.println("<input type='submit' value='Valider'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
			doGet(request, response);
	}
	
	

}

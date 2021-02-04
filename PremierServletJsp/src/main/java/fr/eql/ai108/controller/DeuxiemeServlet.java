package fr.eql.ai108.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SecondServlet")
public class DeuxiemeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public DeuxiemeServlet() {
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
			out.println("<title>Seconde Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Vos informations</h1>");
			out.println("<ul>");
			out.println("<li>Login: " + request.getParameter("login") + "</li>");
			out.println("<li>Password: " + request.getParameter("password") + "</li>");
			out.println("<li>Sexe: " + request.getParameter("sexe") + "</li>");
			out.println("<li>Pays: " + request.getParameter("pays") + "</li>");
			out.println("<li>Optin: " + request.getParameter("optin") + "</li>");
			out.println("</ul>");
			out.println("<a href='ThirdServlet'>Page suivante</a>");
			out.println("</body>");
			out.println("</html>");
			
			HttpSession session = request.getSession();
			session.setAttribute("leLogin", request.getParameter("login"));

	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
			doGet(request, response);
	}

	
}

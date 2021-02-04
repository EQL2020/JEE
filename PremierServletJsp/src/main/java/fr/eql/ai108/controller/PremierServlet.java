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
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
			doGet(request, response);
	}
	
	

}

package fr.eql.ai108.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculServletV2
 */
@WebServlet("/calculV2")
public class CalculServletV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculServletV2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
				
				//Stocker les résultats dans la requête
				request.setAttribute("operation", operation);
				request.setAttribute("resultat", num3);
				
				//Rediriger vers une JSP qui affichera le résultat
				RequestDispatcher disp = request.getRequestDispatcher("resultatV2.jsp");
				disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

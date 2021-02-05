package fr.eql.ai108.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eql.ai108.modele.CalculService;
import fr.eql.ai108.modele.Resultat;

/**
 * Servlet implementation class CalculServletV3
 */
@WebServlet("/calculV3")
public class CalculServletV3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculServletV3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Récupération des params:
		String op = request.getParameter("op");
		String nb1 = request.getParameter("n1");
		String nb2 = request.getParameter("n2");
		
		//Verification des champs/conversion
		int num1 = Integer.parseInt(nb1);
		int num2 = Integer.parseInt(nb2);
		
		//Traitement/Calcul: Appel à nos services
		CalculService service = new CalculService();
		Resultat res = service.calcul(op, num1, num2);
		
		//Stocker le résultat dans la requête
		request.setAttribute("resultat", res);
		
		//Redirection vers une JSP
		RequestDispatcher disp = request.getRequestDispatcher("resultatV3.jsp");
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

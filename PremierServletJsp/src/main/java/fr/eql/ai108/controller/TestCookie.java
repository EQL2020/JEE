package fr.eql.ai108.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestCookie
 */
@WebServlet("/cookie.xyz")
public class TestCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Vérifier si l'utilsateur possède déjà le cookie
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("prenom")) {
					request.setAttribute("prenom", cookie.getValue());
				}

			}
		}
		//On redirige l'utilisateur vers une jsp avec un affichage conditionnel
			//Si cookie: "Coucou nom"
			//Si pas cookie: formulaire d'identification
		request.getRequestDispatcher("cookie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lorsque l'utilisateur se connecte pour la première, 
		//on met le cookie dans son navigateur
		String prenom = request.getParameter("prenom");
		Cookie cookie = new Cookie("prenom", prenom);
		cookie.setMaxAge(60 * 60* 24 * 30);
		response.addCookie(cookie);
		
		//On le redirige vers cookie.xyz
		response.sendRedirect("cookie.xyz");
	}

}

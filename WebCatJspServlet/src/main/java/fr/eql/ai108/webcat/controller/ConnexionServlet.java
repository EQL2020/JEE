package fr.eql.ai108.webcat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eql.ai108.dao.Cat;
import fr.eql.ai108.dao.DaoCat;
import fr.eql.ai108.dao.DaoUser;
import fr.eql.ai108.dao.IDaoCat;
import fr.eql.ai108.dao.IDaoUser;
import fr.eql.ai108.dao.User;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDaoUser daoUser = new DaoUser();
		String message = null;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		User user = daoUser.authenticate(login, password);
		
		if(user != null) {
			//Forward vers la page d'affichage des chats
			IDaoCat daoCat = new DaoCat();
			List<Cat> cats = daoCat.getCatByUser(user);
			request.setAttribute("cats", cats);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("displayUsersCat.jsp").forward(request, response);
		}else {
			message = "Login ou password incorrect";
			request.setAttribute("message", message);
			request.getRequestDispatcher("connexion.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package fr.eql.ai108.jsf2.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.eql.ai108.dao.DaoUser;
import fr.eql.ai108.dao.IDaoUser;
import fr.eql.ai108.dao.User;

@ManagedBean (name = "mbConnect")
@SessionScoped
public class ConnexionManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String login;
	private String password;
	private User user;
	private IDaoUser dao = new DaoUser();
	
	public String connect() {
		String retour = "";
		user = dao.authenticate(login, password);
		if (user != null) {
			retour = "/pageConnectee.xhtml?faces-redirect=true";
		}else {
			System.out.println("Coucou Else");
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
					"Login et/ou Password incorrect", "azertyuiop"));
			FacesContext.getCurrentInstance().addMessage("form:password", 
					new FacesMessage("Un message ciblé"));
		}
		return retour;
	}
	
	public String disconnect() {
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		//Réinitialisation des champs:
		login = "";
		password = "";
		user = new User();
		
		return "/connexion.xhtml?faces-redirect=true";
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}

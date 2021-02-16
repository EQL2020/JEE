package fr.eql.ai108.jsf2.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
		}
		return retour;
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

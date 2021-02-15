package fr.eql.ai108.jsf.controller;

import java.io.Serializable;

import fr.eql.ai108.dao.DaoUser;
import fr.eql.ai108.dao.IDaoUser;
import fr.eql.ai108.dao.User;

public class ConnexionManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	//Données manipulées par le Managed Bean
	private String login;
	private String password;
	private User user;
	
	private IDaoUser dao = new DaoUser();
	
	public User connect() {
		user = dao.authenticate(login, password);
		return user;
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

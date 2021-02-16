package fr.eql.ai108.jsf2.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import fr.eql.ai108.dao.DaoUser;
import fr.eql.ai108.dao.IDaoUser;
import fr.eql.ai108.dao.User;

@ManagedBean (name = "mbAccount")
@SessionScoped
public class AccountManagedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String surname;
	@Size(min = 2, max=10, message = "Fatal Size Error")
	private String login;
	@Pattern (regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})", 
			message = "Le password soit comprendre un digit, une minuscule, une majuscule, "
					+ "un caractère spécial et sa taille doit être comprise entre et 20 caractères")
	private String password;
	private String message = "";
	private User user;
	private IDaoUser dao = new DaoUser();
	
	public String validate() {
		return "/confirmation.xhtml?faces-redirect=true";
	}
	
	public String createAccount() {
		user = new User(null, login, password, name, surname);
		dao.insertUser(user);
		message = "Utilisateur " + user.getName() + " bien créé";
		user = new User();
		name = "";
		surname= "";
		login = "";
		password = "";
		return "/createAccount.xhtml?faces-redirect=true";
	}
	
	public String cancel() {
		name = "";
		surname= "";
		login = "";
		password = "";
		message = "";
		return "/createAccount.xhtml?faces-redirect=true";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}

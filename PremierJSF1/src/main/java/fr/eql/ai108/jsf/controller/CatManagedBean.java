package fr.eql.ai108.jsf.controller;

import java.io.Serializable;

import fr.eql.ai108.dao.User;

public class CatManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Comment récupérer dans ce bean l'utilisateur en session
	private User userConnected;

	public User getUserConnected() {
		return userConnected;
	}

	public void setUserConnected(User userConnected) {
		this.userConnected = userConnected;
	}
	
	//Je souhaite afficher les chats d'un utilisateur connecté

}

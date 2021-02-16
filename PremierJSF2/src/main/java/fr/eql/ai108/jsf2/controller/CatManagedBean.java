package fr.eql.ai108.jsf2.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.eql.ai108.dao.Cat;
import fr.eql.ai108.dao.DaoCat;
import fr.eql.ai108.dao.IDaoCat;
import fr.eql.ai108.dao.User;

@ManagedBean (name = "mbCat")
@RequestScoped
public class CatManagedBean {
	
	private List<Cat> cats;
	private IDaoCat dao = new DaoCat();
	private List<Cat> connectedUsersCats;
	

	@ManagedProperty (value = "#{mbConnect.user}")
	private User userConnected;
	


	public String deleteCat(Cat cat) {
		System.out.println(cat.toString());
		dao.delete(cat);
		return "/displayCat.xhtml?faces-redirect=true";
	}
	
	@PostConstruct
	public void init() {
		cats = dao.getAll();
		if (userConnected != null) {
			//charger en mémoire la liste de chat du user
			connectedUsersCats = dao.getCatByUser(userConnected);
		}
	}

	public List<Cat> getCats() {
		return cats;
	}

	public void setCats(List<Cat> cats) {
		this.cats = cats;
	}
	
	public User getUserConnected() {
		return userConnected;
	}
	public void setUserConnected(User userConnected) {
		this.userConnected = userConnected;
	}
	public List<Cat> getConnectedUsersCats() {
		return connectedUsersCats;
	}

	public void setConnectedUsersCats(List<Cat> connectedUsersCats) {
		this.connectedUsersCats = connectedUsersCats;
	}
}

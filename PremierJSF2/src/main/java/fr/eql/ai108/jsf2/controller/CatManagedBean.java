package fr.eql.ai108.jsf2.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.eql.ai108.dao.Cat;
import fr.eql.ai108.dao.DaoCat;
import fr.eql.ai108.dao.IDaoCat;

@ManagedBean (name = "mbCat")
@RequestScoped
public class CatManagedBean {
	
	private List<Cat> cats;
	private IDaoCat dao = new DaoCat();
	
	public String deleteCat(Cat cat) {
		System.out.println(cat.toString());
		dao.delete(cat);
		return "/displayCat.xhtml?faces-redirect=true";
	}
	
	@PostConstruct
	public void init() {
		cats = dao.getAll();
	}

	public List<Cat> getCats() {
		return cats;
	}

	public void setCats(List<Cat> cats) {
		this.cats = cats;
	}

}

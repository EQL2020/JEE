package fr.eql.ai108.jee.appcat.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.eql.ai108.jee.appcat.entity.Cat;
import fr.eql.ai108.jee.appcat.ibusiness.api.CatIBusiness;

@ManagedBean (name = "mbCat")
@RequestScoped
public class CatManagedBean {
	
	private List<Cat> cats;
	private Cat selectedCat;
	

	@EJB
	private CatIBusiness proxyCatBu;
	
	@PostConstruct
	public void init() {
		cats = proxyCatBu.displayCat();
	}
	
	public void printSelectedCat() {
		System.out.println(selectedCat.toString());
	}

	public List<Cat> getCats() {
		return cats;
	}

	public void setCats(List<Cat> cats) {
		this.cats = cats;
	}
	public Cat getSelectedCat() {
		return selectedCat;
	}

	public void setSelectedCat(Cat selectedCat) {
		this.selectedCat = selectedCat;
	}

}

package fr.eql.ai108.jsf2.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean (name = "mbPremier")
@RequestScoped
public class PremierManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String saisie;
	private String label;
	
	public String click() {
		label = saisie;
		String retour;
		switch (saisie) {
		case "toto":
			retour = "/helloToto.xhtml?faces-redirect=true";			
			break;
		case "tata":
			retour = "/helloTata.xhtml?faces-redirect=true";
			break;
		default:
			retour = saisie;
			break;
		}
		System.out.println(retour);
		return retour;
	}
	
	public String getSaisie() {
		return saisie;
	}
	public void setSaisie(String saisie) {
		this.saisie = saisie;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}

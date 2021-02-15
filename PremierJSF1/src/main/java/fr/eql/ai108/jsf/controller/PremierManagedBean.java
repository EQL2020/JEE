package fr.eql.ai108.jsf.controller;

public class PremierManagedBean {
	
	//Données manipulées par la vue et le serveur:
	private String saisie;
	private String label;
	
	public String click() {
		label = saisie;
		saisie= "";
		return label;
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

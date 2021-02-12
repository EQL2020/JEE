package fr.eql.ai108.struts.actionform;

import org.apache.struts.action.ActionForm;

public class PremierActionForm extends ActionForm{

	private static final long serialVersionUID = 1L;
	
	private String saisie;
	private String label;
	
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

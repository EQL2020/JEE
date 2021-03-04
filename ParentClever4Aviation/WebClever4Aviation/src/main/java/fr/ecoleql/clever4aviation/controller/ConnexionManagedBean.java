package fr.ecoleql.clever4aviation.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.ecoleql.clever4aviation.entity.Utilisateur;
import fr.ecoleql.clever4aviation.ibusiness.CompteIBusiness;

@ManagedBean (name = "mbConnexion")
@SessionScoped
public class ConnexionManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private Utilisateur utilisateur;
	
	@EJB
	private CompteIBusiness proxyCompteBu;
	
	public String connexion(){
		utilisateur = proxyCompteBu.connexion(login, password);
		String retour = null;
		if (utilisateur != null){
			switch (utilisateur.getTypeUtilisateur().getAutorisation()) {
			case "Admin":
				retour = "/dossierVol.xhtml?faces-redirect=true";
				break;
			case "Pilote":
				retour = "/dossierVol.xhtml?faces-redirect=true";
				break;
			case "PSS":
				retour = "/securiteSol.xhtml?faces-redirect=true";
				break;
			case "PSV":
				retour = "/securiteVol.xhtml?faces-redirect=true";
				break;
			case "Mecano":
				retour = "/defaut.xhtml?faces-redirect=true";
				break;

			default:
				break;
			}
		}else{
			retour= "/index.xhtml?faces-redirect=true";
		}
		return retour;
	}
	
	public String deconnexion() {
        utilisateur = null;
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
        return "/index.xhtml?faces-redirect=true";
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
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}

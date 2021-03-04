package fr.ecoleql.clever4aviation.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;

import fr.ecoleql.clever4aviation.entity.Avion;
import fr.ecoleql.clever4aviation.entity.Defaut;
import fr.ecoleql.clever4aviation.entity.Historique;
import fr.ecoleql.clever4aviation.entity.Utilisateur;
import fr.ecoleql.clever4aviation.ibusiness.MecanoIBusiness;


@ManagedBean(name = "mbMecano")
@ViewScoped
public class MecanoManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Avion> avions;
	private List<Avion> filteredAvions;
	private Avion selectedAvion;
	private List<Defaut> defauts;
	private Defaut nouveauDefaut;
	private String immatriculation;
	private Defaut selectedDefaut;
	private Integer activeTabIndex;
	private List<Historique> historiques;
	private Integer referenceNouveauDefaut;
	private String immatriculationAvionDefautAjout;
	
	@ManagedProperty (value="#{mbConnexion.utilisateur}")
	private Utilisateur user;
		
	@EJB
	private MecanoIBusiness proxyMecanoBu;
	
	public void afficherDefautParAvion() {
		selectedAvion = proxyMecanoBu.afficherAvionParImmatriculation(immatriculation);
		defauts = proxyMecanoBu.afficherDefautsParAvion(selectedAvion);
	}
	public void afficherHistoriqueParDefaut() {
		historiques = proxyMecanoBu.afficherHistoriqueParDefaut(selectedDefaut);
	}
	public void majDefaut() {
		proxyMecanoBu.mettreAJourDefaut(selectedDefaut);
		Historique historique = new Historique();
		historique.setDateModif(new Date());
		historique.setDefaut(selectedDefaut);
		historique.setDerniereAction("M");
		Integer version = proxyMecanoBu.obtenirNumeroVersion(selectedDefaut);
		historique.setNumVersion(version);
		historique.setUtilisateur(user);
		proxyMecanoBu.ajouterHistorique(historique);
		selectedDefaut = new Defaut();
		defauts = proxyMecanoBu.afficherDefautsParAvion(selectedAvion);
		activeTabIndex = 1;
	}

	public void ajouterDefaut() {
		nouveauDefaut.setDateCreation(new Date());
		nouveauDefaut.setReference(referenceNouveauDefaut);
		Avion avion = proxyMecanoBu.afficherAvionParImmatriculation(immatriculationAvionDefautAjout);
		if (avion != null) {
		nouveauDefaut.setAvion(avion);		
		nouveauDefaut = proxyMecanoBu.ajouterDefaut(nouveauDefaut);	
		Historique historique = new Historique();
		historique.setDateModif(new Date());
		historique.setDefaut(nouveauDefaut);
		historique.setDerniereAction("C");
		historique.setNumVersion(1);
		historique.setUtilisateur(user);
		proxyMecanoBu.ajouterHistorique(historique);
		nouveauDefaut = new Defaut();
		defauts = proxyMecanoBu.afficherDefautsParAvion(selectedAvion);
		referenceNouveauDefaut = proxyMecanoBu.obtenirNouvelleReferenceDefaut();
		immatriculationAvionDefautAjout = "";
		avion = null;
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur d'immatriculation: le défaut n'a pas été ajouté", "Erreur d'immatriculation: le défaut n'a pas été ajouté"));
		}		
	}
	public void effacerDefaut() {
		proxyMecanoBu.supprimerDefaut(selectedDefaut);
		defauts = proxyMecanoBu.afficherDefautsParAvion(selectedAvion);
		selectedDefaut = new Defaut();
		activeTabIndex = 1;
	}
	

	@PostConstruct
	public void init() {
		referenceNouveauDefaut = proxyMecanoBu.obtenirNouvelleReferenceDefaut();
		nouveauDefaut = new Defaut();	
	}
	
	public List<Defaut> getDefauts() {
		return defauts;
	}


	public void setDefauts(List<Defaut> defauts) {
		this.defauts = defauts;
	}


	public Avion getSelectedAvion() {
		return selectedAvion;
	}

	public void setSelectedAvion(Avion selectedAvion) {
		this.selectedAvion = selectedAvion;
	}

	public List<Avion> getAvions() {
		return avions;
	}

	public void setAvions(List<Avion> avions) {
		this.avions = avions;
	}
	public List<Avion> getFilteredAvions() {
		return filteredAvions;
	}

	public void setFilteredAvions(List<Avion> filteredAvions) {
		this.filteredAvions = filteredAvions;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Defaut getSelectedDefaut() {
		return selectedDefaut;
	}

	public void setSelectedDefaut(Defaut selectedDefaut) {
		this.selectedDefaut = selectedDefaut;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Integer getActiveTabIndex() {
		return activeTabIndex;
	}

	public void setActiveTabIndex(Integer activeTabIndex) {
		this.activeTabIndex = activeTabIndex;
	}
	public List<Historique> getHistoriques() {
		return historiques;
	}
	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}
	public Defaut getNouveauDefaut() {
		return nouveauDefaut;
	}
	public void setNouveauDefaut(Defaut nouveauDefaut) {
		this.nouveauDefaut = nouveauDefaut;
	}
	public Integer getReferenceNouveauDefaut() {
		return referenceNouveauDefaut;
	}
	public void setReferenceNouveauDefaut(Integer referenceNouveauDefaut) {
		this.referenceNouveauDefaut = referenceNouveauDefaut;
	}
	public String getImmatriculationAvionDefautAjout() {
		return immatriculationAvionDefautAjout;
	}
	public void setImmatriculationAvionDefautAjout(String immatriculationAvionDefautAjout) {
		this.immatriculationAvionDefautAjout = immatriculationAvionDefautAjout;
	}	
}

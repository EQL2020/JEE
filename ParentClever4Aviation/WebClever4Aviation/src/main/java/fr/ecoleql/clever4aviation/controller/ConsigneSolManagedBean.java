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

import fr.ecoleql.clever4aviation.entity.Aeroport;
import fr.ecoleql.clever4aviation.entity.Avion;
import fr.ecoleql.clever4aviation.entity.ConsigneSurete;
import fr.ecoleql.clever4aviation.entity.Defaut;
import fr.ecoleql.clever4aviation.entity.Historique;
import fr.ecoleql.clever4aviation.entity.TypeConsigne;
import fr.ecoleql.clever4aviation.entity.Utilisateur;
import fr.ecoleql.clever4aviation.ibusiness.GestionConsigneIBusiness;
import fr.ecoleql.clever4aviation.ibusiness.MecanoIBusiness;


@ManagedBean(name = "mbConsigneSol")
@ViewScoped
public class ConsigneSolManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Aeroport> aeroports;
	private List<ConsigneSurete> consignes;
	private ConsigneSurete nouvelleConsigne = new ConsigneSurete();
	private ConsigneSurete selectedConsigne;
	private Integer activeTabIndex;
	private List<Historique> historiques;
	private Integer referenceNouvelleConsigne;
	private Integer idAeroportOrigine;
	private Integer idAeroportDepart;
	private Integer idAeroportArrivee;

	
	@ManagedProperty (value="#{mbConnexion.utilisateur}")
	private Utilisateur user;
		
	@EJB
	private GestionConsigneIBusiness proxyConsigneBu ;
	

	public void afficherHistoriqueParConsigne() {
		historiques = proxyConsigneBu.afficherHistoriqueParConsigne(selectedConsigne);
	}
	public void majConsigne() {
		proxyConsigneBu.mettreAJourConsigne(selectedConsigne);
		Historique historique = new Historique();
		historique.setDateModif(new Date());
		historique.setConsigne(selectedConsigne);
		historique.setDerniereAction("M");
		Integer version = proxyConsigneBu.obtenirNumeroVersion(selectedConsigne);
		historique.setNumVersion(version);
		historique.setUtilisateur(user);
		proxyConsigneBu.ajouterHistorique(historique);
		selectedConsigne = new ConsigneSurete();
		consignes = proxyConsigneBu.afficherConsigneParType("sol");
		activeTabIndex = 1;
	}

	public void ajouterConsigne() {
		
		nouvelleConsigne.setReference(referenceNouvelleConsigne);
		if (idAeroportOrigine != null) {
			nouvelleConsigne.setAeroportOrigine(proxyConsigneBu.obtenirAeroportParId(idAeroportOrigine));
		}
		if (idAeroportDepart != null) {
			nouvelleConsigne.setAeroportDepart(proxyConsigneBu.obtenirAeroportParId(idAeroportOrigine));
		}
		if (idAeroportArrivee != null) {
			nouvelleConsigne.setAeroportArrivee(proxyConsigneBu.obtenirAeroportParId(idAeroportOrigine));
		}
		TypeConsigne sol = new TypeConsigne();
		sol.setId(2);
		nouvelleConsigne.setTypeConsigne(sol);
				
		nouvelleConsigne = proxyConsigneBu.ajouterConsigne(nouvelleConsigne);	
		Historique historique = new Historique();
		historique.setDateModif(new Date());
		historique.setConsigne(nouvelleConsigne);
		historique.setDerniereAction("C");
		historique.setNumVersion(1);
		historique.setUtilisateur(user);
		proxyConsigneBu.ajouterHistorique(historique);
		nouvelleConsigne = new ConsigneSurete();
		idAeroportArrivee = null;
		idAeroportDepart = null;
		idAeroportOrigine = null;
		consignes = proxyConsigneBu.afficherConsigneParType("sol");
		referenceNouvelleConsigne = proxyConsigneBu.obtenirNouvelleReferenceConsigne();

		
	}
	public void effacerConsigne() {
		proxyConsigneBu.supprimerConsigne(selectedConsigne);;
		consignes = proxyConsigneBu.afficherConsigneParType("sol");
		selectedConsigne = new ConsigneSurete();
		activeTabIndex = 1;
	}

	@PostConstruct
	public void init() {
		consignes =proxyConsigneBu.afficherConsigneParType("sol");
		referenceNouvelleConsigne = proxyConsigneBu.obtenirNouvelleReferenceConsigne();
		aeroports = proxyConsigneBu.displayAllAirport();
	}
	public List<Aeroport> getAeroports() {
		return aeroports;
	}
	public void setAeroports(List<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}
	public List<ConsigneSurete> getConsignes() {
		return consignes;
	}
	public void setConsignes(List<ConsigneSurete> consignes) {
		this.consignes = consignes;
	}
	public ConsigneSurete getNouvelleConsigne() {
		return nouvelleConsigne;
	}
	public void setNouvelleConsigne(ConsigneSurete nouvelleConsigne) {
		this.nouvelleConsigne = nouvelleConsigne;
	}
	public ConsigneSurete getSelectedConsigne() {
		return selectedConsigne;
	}
	public void setSelectedConsigne(ConsigneSurete selectedConsigne) {
		this.selectedConsigne = selectedConsigne;
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
	public Integer getReferenceNouvelleConsigne() {
		return referenceNouvelleConsigne;
	}
	public void setReferenceNouvelleConsigne(Integer referenceNouvelleConsigne) {
		this.referenceNouvelleConsigne = referenceNouvelleConsigne;
	}
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	public Integer getIdAeroportOrigine() {
		return idAeroportOrigine;
	}
	public void setIdAeroportOrigine(Integer idAeroportOrigine) {
		this.idAeroportOrigine = idAeroportOrigine;
	}
	public Integer getIdAeroportDepart() {
		return idAeroportDepart;
	}
	public void setIdAeroportDepart(Integer idAeroportDepart) {
		this.idAeroportDepart = idAeroportDepart;
	}
	public Integer getIdAeroportArrivee() {
		return idAeroportArrivee;
	}
	public void setIdAeroportArrivee(Integer idAeroportArrivee) {
		this.idAeroportArrivee = idAeroportArrivee;
	}
}

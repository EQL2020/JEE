package fr.ecoleql.clever4aviation.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historique")
public class Historique implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numVersion;
	private String derniereAction;
	private Date dateModif;
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	@ManyToOne
	private Defaut defaut;
	
	@ManyToOne
	private ConsigneSurete consigne;
	
	public Historique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Historique(Integer id, Integer numVersion, String derniereAction, Date dateModif, Utilisateur utilisateur,
			Defaut defaut, ConsigneSurete consigne) {
		super();
		this.id = id;
		this.numVersion = numVersion;
		this.derniereAction = derniereAction;
		this.dateModif = dateModif;
		this.utilisateur = utilisateur;
		this.defaut = defaut;
		this.consigne = consigne;
	}

	public Integer getId() {
		return id;
	}

	public Integer getNumVersion() {
		return numVersion;
	}

	public String getDerniereAction() {
		return derniereAction;
	}

	public Date getDateModif() {
		return dateModif;
	}

	public Defaut getDefaut() {
		return defaut;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNumVersion(Integer numVersion) {
		this.numVersion = numVersion;
	}

	public void setDerniereAction(String derniereAction) {
		this.derniereAction = derniereAction;
	}

	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}

	public void setDefaut(Defaut defaut) {
		this.defaut = defaut;
	}


	public ConsigneSurete getConsigne() {
		return consigne;
	}

	public void setConsigne(ConsigneSurete consigne) {
		this.consigne = consigne;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}

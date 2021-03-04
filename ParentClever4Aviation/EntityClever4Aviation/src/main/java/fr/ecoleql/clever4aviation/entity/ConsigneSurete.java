package fr.ecoleql.clever4aviation.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "consigne_surete")
public class ConsigneSurete implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer reference;
	private Date dateDebutApplication;
	private Date dateFinApplication;
	private String titre;
	private String code;
	private String corpsMessage;
	private String remarque;
	
	@OneToMany (mappedBy = "consigne", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Historique> historiques;
	
	@ManyToOne
	private TypeConsigne typeConsigne;
	
	@ManyToOne
	private Aeroport aeroportOrigine;
	
	@ManyToOne
	private Aeroport aeroportDepart;
	
	@ManyToOne
	private Aeroport aeroportArrivee;
	
	public ConsigneSurete() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConsigneSurete(Integer id, Integer reference, Date dateDebutApplication, Date dateFinApplication,
			String titre, String code, String corpsMessage, String remarque, List<Historique> historiques,
			TypeConsigne typeConsigne, Aeroport aeroportOrigine, Aeroport aeroportDepart, Aeroport aeroportArrivee) {
		super();
		this.id = id;
		this.reference = reference;
		this.dateDebutApplication = dateDebutApplication;
		this.dateFinApplication = dateFinApplication;
		this.titre = titre;
		this.code = code;
		this.corpsMessage = corpsMessage;
		this.remarque = remarque;
		this.historiques = historiques;
		this.typeConsigne = typeConsigne;
		this.aeroportOrigine = aeroportOrigine;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReference() {
		return reference;
	}

	public void setReference(Integer reference) {
		this.reference = reference;
	}

	public Date getDateDebutApplication() {
		return dateDebutApplication;
	}

	public void setDateDebutApplication(Date dateDebutApplication) {
		this.dateDebutApplication = dateDebutApplication;
	}

	public Date getDateFinApplication() {
		return dateFinApplication;
	}

	public void setDateFinApplication(Date dateFinApplication) {
		this.dateFinApplication = dateFinApplication;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCorpsMessage() {
		return corpsMessage;
	}

	public void setCorpsMessage(String corpsMessage) {
		this.corpsMessage = corpsMessage;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public TypeConsigne getTypeConsigne() {
		return typeConsigne;
	}

	public void setTypeConsigne(TypeConsigne typeConsigne) {
		this.typeConsigne = typeConsigne;
	}

	public Aeroport getAeroportOrigine() {
		return aeroportOrigine;
	}

	public void setAeroportOrigine(Aeroport aeroportOrigine) {
		this.aeroportOrigine = aeroportOrigine;
	}

	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	public List<Historique> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}
}

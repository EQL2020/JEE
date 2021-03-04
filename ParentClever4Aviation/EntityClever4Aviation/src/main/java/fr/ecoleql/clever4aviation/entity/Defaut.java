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
@Table (name = "defaut")
public class Defaut implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titre;
	private Integer reference;
	private Date dateCreation;
	private String attentionImmediate;
	private String observation;
	private String etatModification;
	private String remarque;
	@ManyToOne
	private Avion avion;

	@OneToMany (mappedBy = "defaut", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Historique> historiques;

	public Defaut() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Defaut(Integer id, String titre, Integer reference, Date dateCreation, String attentionImmediate,
			String observation, String etatModification, String remarque, Avion avion, List<Historique> historiques) {
		super();
		this.id = id;
		this.titre = titre;
		this.reference = reference;
		this.dateCreation = dateCreation;
		this.attentionImmediate = attentionImmediate;
		this.observation = observation;
		this.etatModification = etatModification;
		this.remarque = remarque;
		this.avion = avion;
		this.historiques = historiques;
	}

	public List<Historique> getHistoriques() {
		return historiques;
	}
	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getAttentionImmediate() {
		return attentionImmediate;
	}

	public void setAttentionImmediate(String attentionImmediate) {
		this.attentionImmediate = attentionImmediate;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getEtatModification() {
		return etatModification;
	}

	public void setEtatModification(String etatModification) {
		this.etatModification = etatModification;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Integer getReference() {
		return reference;
	}

	public void setReference(Integer reference) {
		this.reference = reference;
	}

}

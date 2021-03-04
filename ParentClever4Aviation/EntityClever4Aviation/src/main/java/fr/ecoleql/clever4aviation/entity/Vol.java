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
@Table (name = "vol")
public class Vol implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String numero;
	
	private Date dateVol;
	
	@ManyToOne
	private Avion avion;
	
	@ManyToOne
	private Aeroport aeroportOrigine;
	
	@ManyToOne
	private Aeroport aeroportDepart;
	
	@ManyToOne
	private Aeroport aeroportArrivee;
	
	
	public Vol() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Vol(Integer id, String numero, Date dateVol, Avion avion, Aeroport aeroportOrigine, Aeroport aeroportDepart,
			Aeroport aeroportArrivee) {
		super();
		this.id = id;
		this.numero = numero;
		this.dateVol = dateVol;
		this.avion = avion;
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


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Date getDateVol() {
		return dateVol;
	}


	public void setDateVol(Date dateVol) {
		this.dateVol = dateVol;
	}


	public Avion getAvion() {
		return avion;
	}


	public void setAvion(Avion avion) {
		this.avion = avion;
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
	
	
}

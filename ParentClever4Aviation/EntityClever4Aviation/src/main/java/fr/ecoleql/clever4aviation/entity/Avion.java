package fr.ecoleql.clever4aviation.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "avion")
public class Avion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String immatriculation;
	
	@ManyToOne
	private TypeAvion typeAvion;

	@OneToMany(mappedBy = "avion",fetch = FetchType.EAGER)
	private List<Defaut> defauts;

	public Avion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Avion(Integer id, String immatriculation, TypeAvion typeAvion, List<Defaut> defauts) {
		super();
		this.id = id;
		this.immatriculation = immatriculation;
		this.typeAvion = typeAvion;
		this.defauts = defauts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public TypeAvion getTypeAvion() {
		return typeAvion;
	}
	public void setTypeAvion(TypeAvion typeAvion) {
		this.typeAvion = typeAvion;
	}
	public List<Defaut> getDefauts() {
		return defauts;
	}
	public void setDefauts(List<Defaut> defauts) {
		this.defauts = defauts;
	}
}

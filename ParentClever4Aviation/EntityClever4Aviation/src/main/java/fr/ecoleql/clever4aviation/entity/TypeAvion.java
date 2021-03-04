package fr.ecoleql.clever4aviation.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type_avion")
public class TypeAvion implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String modele;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public TypeAvion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeAvion(Integer id, String modele) {
		super();
		this.id = id;
		this.modele = modele;
	}
}

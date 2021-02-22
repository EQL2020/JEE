package fr.eql.ai108.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "person", namespace = "http://ai108.microsoft.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class Personne {
	@XmlElement(name = "identity")
	private int id;
	@XmlElement(name = "firstname")
	private String name;
		
	public Personne(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

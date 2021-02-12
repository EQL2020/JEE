package fr.eql.ai108.dao;

import java.time.LocalDate;
import java.util.Date;

public class Cat {
	
	private Integer id;
	private String name;
	private String race;
	private LocalDate birth;
	private String photo;
	
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cat(Integer id, String name, String race, LocalDate birth, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.race = race;
		this.birth = birth;
		this.photo = photo;
	}

	public Cat(Integer id, String name, String race, LocalDate birth) {
		super();
		this.id = id;
		this.name = name;
		this.race = race;
		this.birth = birth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", race=" + race + ", birth=" + birth + "]";
	}
	
}

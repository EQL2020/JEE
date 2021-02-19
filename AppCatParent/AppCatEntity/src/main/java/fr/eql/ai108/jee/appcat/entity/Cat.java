package fr.eql.ai108.jee.appcat.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "cat")
public class Cat implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column (name = "race")
	private String race;
	@Column (name = "photo")
	private String photo;
	@Column (name = "birth")
	private Date birth;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private User user;
	
    @OneToMany (mappedBy = "cat", cascade = CascadeType.ALL)
    private Set<Toy> toys;
	
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cat(Integer id, String name, String race, String photo, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.race = race;
		this.photo = photo;
		this.birth = birth;
	}	
	public Cat(Integer id, String name, String race, String photo, Date birth, User user) {
		super();
		this.id = id;
		this.name = name;
		this.race = race;
		this.photo = photo;
		this.birth = birth;
		this.user = user;
	}
	
	public Cat(Integer id, String name, String race, String photo, Date birth, User user, Set<Toy> toys) {
		super();
		this.id = id;
		this.name = name;
		this.race = race;
		this.photo = photo;
		this.birth = birth;
		this.user = user;
		this.toys = toys;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (race == null) {
			if (other.race != null)
				return false;
		} else if (!race.equals(other.race))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", race=" + race + ", photo=" + photo + ", birth=" + birth + "]";
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Toy> getToys() {
		return toys;
	}
	public void setToys(Set<Toy> toys) {
		this.toys = toys;
	}	
}

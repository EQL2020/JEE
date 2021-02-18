package fr.eql.ai108.jpa.heritage;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Admin")
public class Administrator extends AppUser {
	private static final long serialVersionUID = 1L;
	private Integer adminCode;
	
	public Administrator(Integer id, String login, String password) {
		super(id, login, password);
		// TODO Auto-generated constructor stub
	}

	public Administrator(Integer id, String login, String password, Integer adminCode) {
		super(id, login, password);
		this.adminCode = adminCode;
	}

	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(Integer adminCode) {
		this.adminCode = adminCode;
	}
}

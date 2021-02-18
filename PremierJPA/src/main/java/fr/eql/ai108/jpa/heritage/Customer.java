package fr.eql.ai108.jpa.heritage;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Customer")
public class Customer extends AppUser {

	private static final long serialVersionUID = 1L;
	
	private Integer cardCode;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer id, String login, String password) {
		super(id, login, password);
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer id, String login, String password, Integer cardCode) {
		super(id, login, password);
		this.cardCode = cardCode;
	}

	public Integer getCardCode() {
		return cardCode;
	}

	public void setCardCode(Integer cardCode) {
		this.cardCode = cardCode;
	}
	
	

}

package fr.eql.ai108.struts.actionform;

import org.apache.struts.action.ActionForm;

import fr.eql.ai108.dao.User;

public class AddUserActionForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	private User user = new User();
	private String message = "";
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}

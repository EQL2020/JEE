package fr.eql.ai108.dao;

public class User {
	
	private Integer id;
	private String login;
	private String password;
	private String name;
	private String surname;
	
	public User(Integer id, String login, String password, String name, String surname) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
		
}

package fr.eql.ai108.dao;

public interface IDaoUser {
	User authenticate(String login, String password);
	void insertUser(User user);
	boolean isExist(User user);
}

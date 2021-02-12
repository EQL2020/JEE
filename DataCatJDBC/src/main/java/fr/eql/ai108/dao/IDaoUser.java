package fr.eql.ai108.dao;

public interface IDaoUser {
	User authenticate(String login, String password);
}

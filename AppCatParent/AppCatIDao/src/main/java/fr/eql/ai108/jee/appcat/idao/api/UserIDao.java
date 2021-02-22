package fr.eql.ai108.jee.appcat.idao.api;

import fr.eql.ai108.jee.appcat.entity.User;

public interface UserIDao extends GenericIDao<User>{
	Boolean exist(User user);
	User authenticate(String login, String password);
}

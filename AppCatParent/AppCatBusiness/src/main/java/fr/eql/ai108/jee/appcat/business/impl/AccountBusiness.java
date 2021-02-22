package fr.eql.ai108.jee.appcat.business.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai108.jee.appcat.entity.User;
import fr.eql.ai108.jee.appcat.ibusiness.api.AccountIBusiness;
import fr.eql.ai108.jee.appcat.idao.api.UserIDao;

@Remote(AccountIBusiness.class)
@Stateless
public class AccountBusiness implements AccountIBusiness {
	
	@EJB
	private UserIDao proxyUser;

	@Override
	public User createAccount(User user) {
		User returnedUser = null;
		if(!(proxyUser.exist(user))) {
			returnedUser = proxyUser.add(user);
		}
		return returnedUser;
	}

	@Override
	public User connection(String login, String password) {
		
		return proxyUser.authenticate(login, password);
	}

}

package fr.ecoleql.clever4aviation.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.ecoleql.clever4aviation.entity.Utilisateur;
import fr.ecoleql.clever4aviation.ibusiness.CompteIBusiness;
import fr.ecoleql.clever4aviation.idao.UtilisateurIDao;

@Remote(CompteIBusiness.class)
@Stateless
public class CompteBusiness implements CompteIBusiness {
	
	@EJB
	private UtilisateurIDao proxyUtilisateurDao;

	@Override
	public Utilisateur connexion(String login, String password) {
		// TODO Auto-generated method stub
		return proxyUtilisateurDao.authenticate(login, password);
	}

}

package fr.ecoleql.clever4aviation.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.ecoleql.clever4aviation.entity.Utilisateur;
import fr.ecoleql.clever4aviation.idao.UtilisateurIDao;

@Remote(UtilisateurIDao.class)
@Stateless
public class UtilisateurDao implements UtilisateurIDao{

	@PersistenceContext(unitName = "PUClever4Aviation")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Utilisateur authenticate(String login, String password) {
		Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login = :paramlogin AND u.password = :parampassword");
		query.setParameter("paramlogin", login);
		query.setParameter("parampassword", password);
		List<Utilisateur> users = query.getResultList();
		Utilisateur user = null;
		if (users.size()>0){
			user = users.get(0);
		}
		return user;
	}

}

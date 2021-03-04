package fr.ecoleql.clever4aviation.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.ecoleql.clever4aviation.entity.Avion;
import fr.ecoleql.clever4aviation.entity.Defaut;
import fr.ecoleql.clever4aviation.idao.DefautIDao;

@Remote (DefautIDao.class)
@Stateless
public class DefautDao implements DefautIDao{
	
	@PersistenceContext(unitName = "PUClever4Aviation")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Defaut> getDefautsByAvion(Avion avion) {
		Query query = em.createQuery("SELECT d from Defaut d WHERE d.avion = :paramAvion");
		query.setParameter("paramAvion", avion);
		List<Defaut> defauts = query.getResultList();
		return defauts;
	}

	@Override
	public Defaut insertDefaut(Defaut defaut) {
		// TODO Auto-generated method stub
		em.persist(defaut);
		return defaut;
	}

	@Override
	public Defaut updateDefaut(Defaut defaut) {
		defaut = em.merge(defaut);
		return defaut;
	}

	@Override
	public void deleteDefaut(Defaut defaut) {
		defaut = em.merge(defaut);
		em.remove(defaut);	
	}

	@Override
	public Integer getLastDefautReference() {
		Query query = em.createQuery("SELECT MAX(d.reference) FROM Defaut d");
		return (Integer) query.getSingleResult();
	}
}

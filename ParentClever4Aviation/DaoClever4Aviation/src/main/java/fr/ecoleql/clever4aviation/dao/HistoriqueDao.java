package fr.ecoleql.clever4aviation.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.ecoleql.clever4aviation.entity.ConsigneSurete;
import fr.ecoleql.clever4aviation.entity.Defaut;
import fr.ecoleql.clever4aviation.entity.Historique;
import fr.ecoleql.clever4aviation.idao.HistoriqueIDao;

@Remote (HistoriqueIDao.class)
@Stateless
public class HistoriqueDao implements HistoriqueIDao {

	@PersistenceContext(unitName = "PUClever4Aviation")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Historique> getHistoriqueByDefaut(Defaut defaut) {
		Query query = em.createQuery("SELECT h from Historique h WHERE h.defaut = :paramDefaut");
		query.setParameter("paramDefaut", defaut);
		List<Historique> historiques = query.getResultList();
		return historiques;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Historique> getHistoriqueByConsigne(ConsigneSurete consigne) {
		Query query = em.createQuery("SELECT h from Historique h WHERE h.consigne = :paramConsigne ORDER BY h.dateModif asc");
		query.setParameter("paramConsigne", consigne);
		List<Historique> historiques = query.getResultList();
		return historiques;
	}

	@Override
	public Historique insertHistorique(Historique historique) {
		em.persist(historique);
		return historique;
	}

	@Override
	public Integer getMaxVersionByDefaut(Defaut defaut) {
		Query query = em.createQuery("SELECT MAX(h.numVersion) FROM Historique h where h.defaut = :paramDefaut");
		query.setParameter("paramDefaut", defaut);
		return (Integer) query.getSingleResult();
	}

	@Override
	public Integer getMaxVersionByConsigne(ConsigneSurete consigne) {
		Query query = em.createQuery("SELECT MAX(h.numVersion) FROM Historique h where h.consigne = :paramConsigne");
		query.setParameter("paramConsigne", consigne);
		return (Integer) query.getSingleResult();
	}


}

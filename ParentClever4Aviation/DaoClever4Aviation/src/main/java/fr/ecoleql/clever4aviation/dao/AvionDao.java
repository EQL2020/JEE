package fr.ecoleql.clever4aviation.dao;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.ecoleql.clever4aviation.entity.Avion;
import fr.ecoleql.clever4aviation.idao.AvionIDao;

@Remote(AvionIDao.class)
@Stateless
public class AvionDao implements AvionIDao {
	
	@PersistenceContext(unitName = "PUClever4Aviation")
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Avion> getAll() {
		Query query = em.createQuery("SELECT a FROM Avion a");
		List<Avion> avions = query.getResultList();
		return avions;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Avion getByImmatriculation(String immatriculation) {
		Query query = em.createQuery("SELECT a FROM Avion a WHERE a.immatriculation = :paramImmatriculation");
		query.setParameter("paramImmatriculation", immatriculation);
		List<Avion> avions = query.getResultList();
		if (avions.size() > 0) {
			return avions.get(0);
		}else {
			return null;
		}	
	}
}

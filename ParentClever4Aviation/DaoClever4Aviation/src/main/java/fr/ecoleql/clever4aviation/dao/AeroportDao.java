package fr.ecoleql.clever4aviation.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.ecoleql.clever4aviation.entity.Aeroport;
import fr.ecoleql.clever4aviation.idao.AeroportIDao;

@Remote (AeroportIDao.class)
@Stateless
public class AeroportDao implements AeroportIDao {
	
		
	@PersistenceContext (unitName = "PUClever4Aviation")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Aeroport> getAll() {
		Query query = em.createQuery("Select a from Aeroport a");
		List<Aeroport> aeroports = query.getResultList();
		return aeroports;
	}

	@Override
	public Aeroport getById(Integer id) {
		Query query = em.createQuery("Select a from Aeroport a where a.id = :paramId");
		query.setParameter("paramId", id);
		List<Aeroport> aeroport = query.getResultList();
		return aeroport.get(0);
	}

}

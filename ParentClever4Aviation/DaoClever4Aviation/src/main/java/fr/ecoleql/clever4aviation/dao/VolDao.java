package fr.ecoleql.clever4aviation.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.ecoleql.clever4aviation.entity.Vol;
import fr.ecoleql.clever4aviation.idao.VolIDao;

@Remote(VolIDao.class)
@Stateless
public class VolDao implements VolIDao {

	@PersistenceContext(unitName = "PUClever4Aviation")
	private EntityManager em;
	
	@Override
	public List<Vol> getAll() {
		Query query = em.createQuery("SELECT v from Vol v");
		List<Vol> vol = query.getResultList();
		return vol;
	}
}

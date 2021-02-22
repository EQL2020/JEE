package fr.eql.ai108.jee.appcat.dao.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai108.jee.appcat.entity.Cat;
import fr.eql.ai108.jee.appcat.idao.api.CatIDao;

@Remote(CatIDao.class)
@Stateless
public class CatDao extends GenericDao<Cat> implements CatIDao {
	
	@PersistenceContext (unitName = "AppCatPU")
	private EntityManager em;

	@Override
	public List<Cat> getAll() {
		Query query = em.createQuery("SELECT c FROM Cat c");
		List<Cat> cats = query.getResultList();
		return cats;
	}

}

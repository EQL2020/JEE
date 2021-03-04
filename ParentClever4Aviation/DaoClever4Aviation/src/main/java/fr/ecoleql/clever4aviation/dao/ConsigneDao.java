package fr.ecoleql.clever4aviation.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.ecoleql.clever4aviation.entity.ConsigneSurete;
import fr.ecoleql.clever4aviation.entity.Vol;
import fr.ecoleql.clever4aviation.idao.ConsigneIDao;


@Remote (ConsigneIDao.class)
@Stateless
public class ConsigneDao implements ConsigneIDao {

	@PersistenceContext(unitName = "PUClever4Aviation")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<ConsigneSurete> getConsigneByType(String type) {
		Query query = em.createQuery("SELECT c from ConsigneSurete c WHERE c.typeConsigne.libelleType = :paramLibelle");
		query.setParameter("paramLibelle", type);
		List<ConsigneSurete> consignes = query.getResultList();
		return consignes;
	}


	@Override
	public ConsigneSurete insertConsigne(ConsigneSurete consigne) {
		em.persist(consigne);
		return consigne;
	}

	@Override
	public ConsigneSurete updateConsigne(ConsigneSurete consigne) {
		consigne = em.merge(consigne);
		return consigne;
	}

	@Override
	public void deleteConsigne(ConsigneSurete consigne) {
		consigne = em.merge(consigne);
		em.remove(consigne);	

	}
	
	@Override
	public Integer getLastConsigneReference() {
		Query query = em.createQuery("SELECT MAX(c.reference) FROM ConsigneSurete c");
		return (Integer) query.getSingleResult();
	}


	@Override
	public List<ConsigneSurete> getConsigneByVol(Vol vol) {
	
		String req = "SELECT c FROM ConsigneSurete c  WHERE c.aeroportDepart = :paramDepart AND c.aeroportOrigine = NULL AND c.aeroportArrivee = NULL and :paramDate BETWEEN c.dateDebutApplication AND c.dateFinApplication"
				+ " OR c.aeroportDepart = NULL AND c.aeroportOrigine = :paramOrigine AND c.aeroportArrivee = NULL and :paramDate BETWEEN c.dateDebutApplication AND c.dateFinApplication"
				+ " OR c.aeroportDepart = :paramDepart AND c.aeroportOrigine = NULL AND c.aeroportArrivee = :paramArrivee and :paramDate BETWEEN c.dateDebutApplication AND c.dateFinApplication"
				+ " OR c.aeroportDepart = :paramDepart AND c.aeroportOrigine = :paramOrigine AND c.aeroportArrivee = NULL and :paramDate BETWEEN c.dateDebutApplication AND c.dateFinApplication "
				+ " OR c.aeroportDepart = NULL AND c.aeroportOrigine = :paramOrigine AND c.aeroportArrivee = :paramArrivee and :paramDate BETWEEN c.dateDebutApplication AND c.dateFinApplication"
				+ " OR c.aeroportDepart = NULL AND c.aeroportOrigine = NULL AND c.aeroportArrivee = :paramArrivee and :paramDate BETWEEN c.dateDebutApplication AND c.dateFinApplication"
				+ " OR c.aeroportDepart = :paramDepart AND c.aeroportOrigine = :paramOrigine AND c.aeroportArrivee = :paramArrivee and :paramDate BETWEEN c.dateDebutApplication AND c.dateFinApplication";
		Query query = em.createQuery(req);
		query.setParameter("paramOrigine", vol.getAeroportOrigine());
		query.setParameter("paramDepart", vol.getAeroportDepart());
		query.setParameter("paramArrivee", vol.getAeroportArrivee());
		query.setParameter("paramDate", vol.getDateVol());
		List<ConsigneSurete> consignes = query.getResultList();
		
		return consignes;
	}

}

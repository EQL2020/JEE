package fr.afcepf.le7o.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import fr.afcepf.le7o.entity.Trainee;

@Component
public class TraineeDao implements TraineeIDao {


	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Trainee> getAllTrainee() {
		List<Trainee> trainees = em.createNamedQuery("Trainee.findAll").getResultList();
		return trainees;
	}

	public void setEm(EntityManager paramEm) {
		em = paramEm;
	}

}

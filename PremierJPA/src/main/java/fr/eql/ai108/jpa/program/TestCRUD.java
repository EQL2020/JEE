package fr.eql.ai108.jpa.program;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.eql.ai108.jpa.entity.User;

public class TestCRUD {

	public static void main(String[] args) {
		// EntityManagerFactory nous permet d'instancier un EntityManager (équivalent
		//de la session Hibernate) en parsant notre persistence.xml
		EntityManagerFactory emf = null;
		//EntityManager nous permet d'ouvrir une transaction et d'interagir avec notre BDD
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("CatPU");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			//Persister un User
			User user = new User(null, "Java", "Persitence API", "JPA", "JPA");
			em.persist(user);
			
			//Rechercher un User par son id
			User toto = em.find(User.class, 1);
			System.out.println("Le user trouvé s'appelle: " + toto.getName());
			
			//Update un User
			//Un user issue de la transaction
			toto.setPassword("123Soleil");
			//Un user qui n'est pas issu de la transaction
			User tata = new User(2, "Tata", "de Tata", "tata", "tata");
			tata.setSurname("de Toto");
			em.merge(tata);
			
			em.getTransaction().commit();
		}catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
			emf.close();
		}

	}

}

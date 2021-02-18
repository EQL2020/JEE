package fr.eql.ai108.jpa.program;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.eql.ai108.jpa.entity.Cat;
import fr.eql.ai108.jpa.entity.User;

public class TestRequete {

	@SuppressWarnings("unchecked")
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
			//Je veux tous les chats !
			//NativeQuery
			Query querySQL = em.createNativeQuery("SeLect * FrOm CaT");
			List<Object[]> cats = querySQL.getResultList();
			for (Object[] objects : cats) {
				System.out.println(objects[2]);
			}
			
			//Idem en JPQL		
			Query queryJPQL = em.createQuery("SELECT c FROM Cat c");
			List<Cat> cats2 = queryJPQL.getResultList();
			for (Cat cat : cats2) {
				System.out.println("En JPQL: " + cat.getName());
			}
			
			//Je veux le nom de l'utilisateur qui possède le chat qui a l'id n°1
			// En SQL natif
			Query querySQL2 = em.createNativeQuery("SELECT user.name FROM"
					+ " user INNER JOIN cat ON user.id=cat.user_id WHERE cat.id = 1");
			String name = (String) querySQL2.getSingleResult();
			System.out.println("En SQL " + name);
			
			//Idem en CRUD JPA
			Cat cat = em.find(Cat.class, 1);
			System.out.println("En CRUD JPA " + cat.getUser().getName());
			
			//En JPQL sans jointure
			Query queryJPQL2 = em.createQuery("SELECT c.user.name FROM Cat c WHERE"
					+ " c.id = 1");
			String name2 = (String) queryJPQL2.getSingleResult();
			System.out.println("En JPQL sans jointure: " + name2);
			
			//En JPQL avec jointure
			Query queryJPQL3 = em.createQuery("SELECT u.name FROM User u INNER JOIN u.cats c WHERE c.id=1");
			String name3 = (String) queryJPQL3.getSingleResult();
			System.out.println("En JPQL avec jointure: " + name3);
			em.getTransaction().commit();
		}catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
			emf.close();
		}
	}
}

